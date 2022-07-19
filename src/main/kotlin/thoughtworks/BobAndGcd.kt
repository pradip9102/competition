package thoughtworks

fun main() {
    repeat(readLine()!!.toInt()) {
        val line1 = readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
        val divisor = line1[0]

        var operationCount = 0L
        readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toLong() }
                .forEach { num ->
                    val option1 = num % divisor
                    val option2 = divisor - option1
                    operationCount += if (option1 < option2) option1 else option2
                }
        println(operationCount)
    }
}