package hackerearth.practo

class BuildingSpeed

fun main(args: Array<String>) {
    val _N = readLine()!!.toInt()
    val _A = readLine()!!
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toList()

    var maxSpeed = 0
    _A.sorted().forEachIndexed { i, speed ->
        if (i % 2 == 0) {
            maxSpeed += speed
        }
    }

    println(maxSpeed)
}