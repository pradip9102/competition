package codechef.ch1804b

class WghtNum {
    companion object {
        const val MODULUS: Long = 1000000007

        fun modularPower(base: Long, exponent: Long, modulus: Long): Long {
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

                println("result: $result")
            }


            return result
        }
    }
}

fun main(args: Array<String>) {
    @Suppress("UNCHECKED_CAST")
    fun <T> readList(delimiter: String = " "): List<T> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it as T }
    }

    (0 until readLine()!!.toInt()).forEach {
        val params = readList<String>()
        val nDigit = params[0].toLong()
        val weight = params[1].toInt()

        val s2 = if (weight < 0) (10 + weight) else (9 - weight)
        if (s2 <= 0) {
            println(0)
        } else {
            println((s2 * WghtNum.modularPower(10, nDigit - 2, WghtNum.MODULUS)).mod(WghtNum.MODULUS))
        }
    }
}