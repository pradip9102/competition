package codechef.goc2018

fun main() {
    repeat(readLine()!!.toInt()) {
        val str = readLine()!!
        val result = str.map { 2 * 'a'.code + 25 - it.code }.map { it.toChar() }.joinToString("")
        println(result)
    }
}