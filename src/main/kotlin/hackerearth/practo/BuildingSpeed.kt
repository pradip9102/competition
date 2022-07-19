package hackerearth.practo

fun main() {
    readLine()!!.toInt()
    val speeds = readLine()!!
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toList()

    var maxSpeed = 0
    speeds.sorted().forEachIndexed { i, speed ->
        if (i % 2 == 0) {
            maxSpeed += speed
        }
    }

    println(maxSpeed)
}