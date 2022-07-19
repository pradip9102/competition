package thoughtworks

fun main() {
    fun readInts() = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    val line1 = readInts()
    val charCount = line1[0]
    val queryCount = line1[1]
    val strA = readLine()!!
    val strB = StringBuilder(readLine()!!)

    var threshold = 0
    while (threshold < charCount && strA[threshold] == strB[threshold]) {
        ++threshold
    }

    (0 until queryCount).forEach {
        val query = readLine()!!.toInt() - 1
        strB[query] = '1'

        if (query == threshold) {
            while (threshold < charCount && strA[threshold] == strB[threshold]) {
                ++threshold
            }
        }

        if (threshold < charCount) {
            println(if (strA[threshold] > strB[threshold]) "NO" else "YES")
        } else {
            println("YES")
        }
    }
}