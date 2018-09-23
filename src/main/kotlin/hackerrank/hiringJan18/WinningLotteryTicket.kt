package hackerrank.hiringJan18

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach {
        val line = readLine()!!
        val nums = Array<Boolean>(10) { false }
        for (ch in line) {
            nums[ch.toString().toInt()]
        }
    }
}