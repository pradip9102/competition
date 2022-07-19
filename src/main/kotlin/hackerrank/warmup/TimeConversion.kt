package hackerrank.warmup

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val normalTime = scanner.nextLine().trim()
    val normalHour = normalTime.substring(0..1)
    val normalPeriod = normalTime.substring(8..9)
    val hour = normalHour.toInt()

    val militaryHour = when (normalPeriod) {
        "AM" -> {
            when {
                hour < 10 -> "0$hour"
                hour < 12 -> "$hour"
                else -> "00"
            }
        }
        "PM" -> {
            when {
                hour < 12 -> "${12 + hour}"
                else -> "12"
            }
        }
        else -> throw IllegalArgumentException("Unknown time!")
    }
    println(militaryHour + normalTime.substring(2..7))
}