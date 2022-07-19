package codechef.ch1803b

import kotlin.math.ceil

class MinEat(val nPile: Int, val nHour: Int, val nBananaInPiles: List<Int>) {
    val nBananaInLargestPile = nBananaInPiles.maxOrNull() ?: -1
    val totalBanana = nBananaInPiles.sumOf { it.toLong() }

    fun canEatAll(speed: Int): Boolean {
        return nBananaInPiles.sumOf { ceil(it.toDouble() / speed) } <= nHour
    }
}

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        val line1 = readIntArray()
        val pchef = MinEat(line1[0], line1[1], readIntArray())

        val optimalSpeed: Int
        if (pchef.nPile == pchef.nHour) {
            optimalSpeed = pchef.nBananaInLargestPile
        } else {
            var minSpeed = ceil(pchef.totalBanana.toDouble() / pchef.nHour).toInt()
            var maxSpeed = pchef.nBananaInLargestPile

            var speed = (minSpeed + maxSpeed) / 2
            while (minSpeed + 1 < maxSpeed) {
                if (pchef.canEatAll(speed)) {
                    maxSpeed = speed
                } else {
                    minSpeed = speed
                }
                speed = (minSpeed + maxSpeed) / 2
            }

            optimalSpeed = if (minSpeed == maxSpeed) {
                speed
            } else {
                if (pchef.canEatAll(minSpeed)) minSpeed else maxSpeed
            }
        }

        println(optimalSpeed)
    }
}