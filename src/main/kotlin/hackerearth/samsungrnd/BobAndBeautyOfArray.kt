package hackerearth.samsungrnd

class BobAndBeautyOfArray {
    companion object {
        const val MAX = 1000000007L
        private fun modularPower(base: Long, exponent: Long, modulus: Long): Long {
            if (modulus == 1L) {
                return 0L
            }

            var result = 1L
            var e = exponent
            var b = base.mod(modulus)
            while (e > 0) {
                if (e.mod(2) != 0L) {
                    result = (result * b).mod(modulus)
                }
                e = e shr 1
                b = (b * b).mod(modulus)
            }

            return result
        }

        fun orRepeatedSum(orResult: Long, rep: Int, remaining: Int): Long {
            var result = 0L
            for (i in 2..rep) {
                result += ((i - 1) * orResult * modularPower(2, (remaining + rep - i).toLong(), MAX)) % MAX
                result %= MAX
            }
            return result
        }

        fun orRepeatedSum(orResult: Long, rep1: Int, rep2: Int, remaining: Int): Long {
            var result = 0L
            for (i in 1..rep2) {
                result += ((rep1 + i - 1) * orResult * modularPower(2, (remaining + rep2 - i).toLong(), MAX)) % MAX
                result %= MAX
            }
            return result
        }
    }
}

fun main(args: Array<String>) {
    // read inputs
    val length = readLine()!!.toInt()
    val array = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }

    // count elements
    val counts = IntArray(1001, { 0 })
    array.forEach { ++counts[it] }
    val elemCounts = IntArray(counts.size)
    for (i in 0 until counts.size) {
        elemCounts[i] = counts[i] + (if (i > 0) elemCounts[i - 1] else 0)
    }

    // compress array
    val compressedArray = array.distinct().sorted()

    // calculate result
    var result = 0L
    for (i in compressedArray.indices) {
        val elemi = compressedArray[i]
        val rep1 = counts[elemi]
        if (counts[compressedArray[i]] >= 2) {
            val remaining = elemCounts[1000] - elemCounts[elemi]
            val orResult = (elemi or elemi).toLong()
            result += BobAndBeautyOfArray.orRepeatedSum(orResult, rep1, remaining)
            result %= BobAndBeautyOfArray.MAX
        }
        for (j in compressedArray.indices.filter { it > i }) {
            val elemj = compressedArray[j]
            val remaining = elemCounts[1000] - elemCounts[elemj]
            val rep2 = counts[elemj]
            val orResult = (elemi or elemj).toLong()
            result += BobAndBeautyOfArray.orRepeatedSum(orResult, rep1, rep2, remaining)
            result %= BobAndBeautyOfArray.MAX
        }
    }
    println(result)
}