package hackerrank.weekofcode37

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine().trim().toInt()

    val ratings = Array<Int>(n) { 0 }
    for (ratingItr in 0 until n) {
        val ratingItem = scanner.nextLine().trim().toInt()
        ratings[ratingItr] = ratingItem
    }

    averageOfTopEmployees(ratings)
}

fun averageOfTopEmployees(ratings: Array<Int>) {
    val topPerformers = ratings.filter { it >= 90 }
    val avg = topPerformers.sum().toDouble() / topPerformers.size
    println("%.2f".format(avg))
}
