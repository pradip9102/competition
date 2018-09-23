package hackerearth.creditsuisse

fun main(args: Array<String>) {
    val line1 = readLine()!!
            .split(" ")
            .map { it.toInt() }
    val N = line1[0]
    val Q = line1[1]

    val array = mutableListOf<Int>()
    for (i in 1..Q) {
        val command = readLine()!!
                .split(" ")
                .map { it.toInt() }
        when(command[0]) {
            1 -> {
                val k = command[1]
                array.add(k)
            }
            2 -> {
                val y = command[1]
                val x = array.sorted().firstOrNull { it >= y }
                println(x ?: -1)
            }
        }
    }
}