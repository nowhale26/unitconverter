package ru.myitschool.lab23

import java.math.BigDecimal
import java.math.RoundingMode

class MetricsData {

}

object MetricsFunctions {
    private val maxScale = 100
    fun converterToAny(tag: String, metricValue: BigDecimal): BigDecimal {
        var convertedValue: BigDecimal = when (tag) {
            "et_inch" -> metricValue * BigDecimal(39.3700787402).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_yard" -> metricValue * BigDecimal(1.09361).setScale(maxScale, RoundingMode.HALF_UP)
            "et_foot" -> metricValue * BigDecimal(3.280839895).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_mile" -> metricValue * BigDecimal(0.000621371).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_yottametre" -> metricValue / BigDecimal(1e24).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_zettametre" -> metricValue / BigDecimal(1e21).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_exametre" -> metricValue / BigDecimal(1e18).setScale(maxScale, RoundingMode.HALF_UP)
            "et_petametre" -> metricValue / BigDecimal(1e15).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_terametre" -> metricValue / BigDecimal(1e12).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_gigametre" -> metricValue / BigDecimal(1e9).setScale(maxScale, RoundingMode.HALF_UP)
            "et_megametre" -> metricValue / BigDecimal(1e6).setScale(maxScale, RoundingMode.HALF_UP)
            "et_kilometre" -> metricValue / BigDecimal(1000).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_hectometre" -> metricValue / BigDecimal(100).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_decametre" -> metricValue / BigDecimal(10).setScale(maxScale, RoundingMode.HALF_UP)
            "et_metre" -> metricValue.setScale(maxScale, RoundingMode.HALF_UP)
            "et_decimetre" -> metricValue * BigDecimal(10).setScale(maxScale, RoundingMode.HALF_UP)
            "et_centimetre" -> metricValue * BigDecimal(100).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_millimetre" -> metricValue * BigDecimal(1000).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_micrometre" -> metricValue * BigDecimal(1e6).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_nanometre" -> metricValue * BigDecimal(1e9).setScale(maxScale, RoundingMode.HALF_UP)
            "et_picometre" -> metricValue * BigDecimal(1e12).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_femtometre" -> metricValue * BigDecimal(1e15).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_attometre" -> metricValue * BigDecimal(1e18).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_zeptometre" -> metricValue * BigDecimal(1e21).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_yoctometre" -> metricValue * BigDecimal(1e24).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            else -> {
                0.toBigDecimal()
            }
        }
        return convertedValue.setScale(maxScale, RoundingMode.HALF_UP)
    }

    fun converterToMeters(tag: String, metricValue: BigDecimal): BigDecimal {
        var convertedValue: BigDecimal = when (tag) {
            "et_inch" -> metricValue / BigDecimal(39.3700787402).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_yard" -> metricValue / BigDecimal(1.09361).setScale(maxScale, RoundingMode.HALF_UP)
            "et_foot" -> metricValue / BigDecimal(3.280839895).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_mile" -> metricValue / BigDecimal(0.000621371).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_yottametre" -> metricValue * BigDecimal(1e24).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_zettametre" -> metricValue * BigDecimal(1e21).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_exametre" -> metricValue * BigDecimal(1e18).setScale(maxScale, RoundingMode.HALF_UP)
            "et_petametre" -> metricValue * BigDecimal(1e15).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_terametre" -> metricValue * BigDecimal(1e12).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_gigametre" -> metricValue * BigDecimal(1e9).setScale(maxScale, RoundingMode.HALF_UP)
            "et_megametre" -> metricValue * BigDecimal(1e6).setScale(maxScale, RoundingMode.HALF_UP)
            "et_kilometre" -> metricValue * BigDecimal(1000).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_hectometre" -> metricValue * BigDecimal(100).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_decametre" -> metricValue * BigDecimal(10).setScale(maxScale, RoundingMode.HALF_UP)
            "et_metre" -> metricValue.setScale(maxScale, RoundingMode.HALF_UP)
            "et_decimetre" -> metricValue / BigDecimal(10).setScale(maxScale, RoundingMode.HALF_UP)
            "et_centimetre" -> metricValue / BigDecimal(100).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_millimetre" -> metricValue / BigDecimal(1000).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_micrometre" -> metricValue / BigDecimal(1e6).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_nanometre" -> metricValue / BigDecimal(1e9).setScale(maxScale, RoundingMode.HALF_UP)
            "et_picometre" -> metricValue / BigDecimal(1e12).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_femtometre" -> metricValue / BigDecimal(1e15).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_attometre" -> metricValue / BigDecimal(1e18).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_zeptometre" -> metricValue / BigDecimal(1e21).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            "et_yoctometre" -> metricValue / BigDecimal(1e24).setScale(
                maxScale,
                RoundingMode.HALF_UP
            )

            else -> {
                0.toBigDecimal()
            }
        }
        return convertedValue.setScale(maxScale, RoundingMode.HALF_UP)
    }



}
