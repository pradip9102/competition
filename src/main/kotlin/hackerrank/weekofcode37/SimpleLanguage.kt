package hackerrank.weekofcode37

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine().trim().toInt()
    var x = 0L
    repeat(n) {
        val params = scanner.nextLine().trim().split(" ")
        val command = params[0]
        val y = params[1].toInt()

        when (command) {
            "add" -> if (x + y > x) x += y
            "set" -> if (y > x) x = y.toLong()
        }
    }

    println(x)
}