package hackerrank.hiringJan18

fun main() {
    repeat(readLine()!!.toInt()) {
        val line = readLine()!!
        val nums = Array<Boolean>(10) { false }
        for (ch in line) {
            nums[ch.toString().toInt()]
        }
    }
}