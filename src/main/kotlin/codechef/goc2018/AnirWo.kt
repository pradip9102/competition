package codechef.goc2018

class AnirWo {
}

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach {
        val ref = 'a'.toInt()
        val str = readLine()!!
        val result = str.map { 2 * ref + 25 - it.toInt() }.map { it.toChar() }.joinToString("")
        println(result)
    }
}