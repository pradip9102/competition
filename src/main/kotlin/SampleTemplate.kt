fun main() {
    /**
     * Read list of integer
     */
    fun readIntList(delimiter: String = " "): List<Int> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it.toInt() }
    }

    fun modularPower(base: Long, exponent: Long, modulus: Long): Long {
        if (modulus == 1L) {
            return 0L
        }

        var result = 1L
        var e = exponent
        var b = base.mod(modulus)
        while (e > 0) {
            if (e.mod(2) != 0) {
                result = (result * b).mod(modulus)
            }
            e = e shr 1
            b = (b * b).mod(modulus)
        }

        return result
    }


    val singleInt = readLine()!!.toInt()
    println(singleInt)

    val str = readLine()!!
    println(str)

    val spaceSeparatedInts = readLine()!!
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    println(spaceSeparatedInts.joinToString())

    val spaceSeparatedWords = readLine()!!
            .split(" ")
    println(spaceSeparatedWords.joinToString())
}