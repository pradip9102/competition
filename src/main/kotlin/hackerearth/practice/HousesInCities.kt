package hackerearth.practice

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

fun main() = try {
    with(BufferedReader(InputStreamReader(System.`in`))) {
        repeat(readLine().toInt()) {
            readLine().toInt()
            val cumulativeHouseCount = mutableListOf(0L)

            readLine()
                    .split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }
                    .forEachIndexed { i, count -> cumulativeHouseCount.add(cumulativeHouseCount[i] + count) }

            println((0 until readLine().toInt()).map {
                val line = readLine().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
                val l = line[0]
                val r = line[1]
                cumulativeHouseCount[r] - cumulativeHouseCount[l - 1]
            }.joinToString("\n"))
        }
    }
} catch (e: Exception) {
    println(e.printStackTrace())
}