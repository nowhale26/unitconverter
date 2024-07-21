package ru.myitschool.lab23

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var lower = 0
    private var upper = 0

    lateinit var mainLayout: LinearLayout
    private val editTextList = mutableListOf<EditText>()
    private lateinit var textWatcher: TextWatcher
    private var isUpdating = false


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainLayout = findViewById(R.id.main)
        lower =
            if (intent.extras?.get("lower") != null) intent.extras?.get("lower") as Int else 0
        upper =
            if (intent.extras?.get("upper") != null) intent.extras?.get("upper") as Int else 1

        var captions = resources.getStringArray(R.array.text_view_captions)
        val tags = resources.getStringArray(R.array.tags)

        var layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )


        textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!isUpdating) {
                    isUpdating = true
                    val newText = s?.toString() ?: ""
                    val currentEditText = getCurrentEditText()
                    updateOtherEditTexts(editTextList,currentEditText, newText)
                    isUpdating = false
                }
            }
        }

        for (i in lower..upper) {
            var linearlayout = LinearLayout(this)
            linearlayout.orientation = LinearLayout.HORIZONTAL
            linearlayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            var textView = TextView(this)
            textView.layoutParams = layoutParams
            textView.text = captions[i]
            textView.id=i+100
            linearlayout.addView(textView)

            var editText = EditText(this)
            editText.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            editText.tag = tags[i]
            editText.id=i
            editText.hint=captions[i]+" "+i+""
            editText.setTextColor(R.color.black)
            linearlayout.addView(editText)
            editTextList.add(editText)
            textView.setOnClickListener {
                val currentEditText = editText
                val valueToCopy = currentEditText.text.toString()
                copyToClipboard(valueToCopy)
            }

            mainLayout.addView(linearlayout)
        }

        textWatcherToAllEditTexts(editTextList)
    }

    private fun textWatcherToAllEditTexts(editTextList: List<EditText>) {
        for (editText in editTextList) {
            editText.addTextChangedListener(textWatcher)
        }
    }

    private fun updateOtherEditTexts(editTexts: List<EditText>,currentEditText: EditText, newText: String) {
        for (editText in editTexts) {
            if (editText.text.toString() != newText && editText!=currentEditText) {
                val tag = currentEditText.tag.toString()
                if (newText==""){
                    editText.setText("")
                }else{
                    val metricValue=MetricsFunctions.converterToMeters(tag,newText.toBigDecimal())
                    var currentValue=MetricsFunctions.converterToAny(editText.tag.toString(),metricValue)
                    currentValue=currentValue.stripTrailingZeros()
                    editText.setText(currentValue.toPlainString())
                }

            }
        }
    }

    private fun getCurrentEditText(): EditText {
        for (editText in editTextList) {
            if (editText.isFocused) {
                return editText
            }
        }
        return editTextList.firstOrNull() ?: throw IllegalStateException("No EditText found")
    }

    private fun copyToClipboard(value: String) {
        val clipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", value)
        clipboardManager.setPrimaryClip(clip)
    }

}


