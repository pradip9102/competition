package codechef.ch1803b

class MinEat(val nPile: Int, val nHour: Int, val nBananaInPiles: List<Int>) {
    val nBananaInLargestPile = nBananaInPiles.max() ?: -1
    val totalBanana = nBananaInPiles.map { it.toLong() }.sum()

    fun canEatAll(speed: Int): Boolean {
        return nBananaInPiles.map { Math.ceil(it.toDouble() / speed) }.sum() <= nHour
    }
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (1..readLine()!!.toInt()).forEach {
        val line1 = readIntArray()
        val pchef = MinEat(line1[0], line1[1], readIntArray())

        val optimalSpeed: Int
        if (pchef.nPile == pchef.nHour) {
            optimalSpeed = pchef.nBananaInLargestPile
        } else {
            var minSpeed = Math.ceil(pchef.totalBanana.toDouble() / pchef.nHour).toInt()
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