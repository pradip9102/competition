package codechef.gsjan18

import java.util.*

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        val targets = readIntArray()
        val cityCount = targets[0]
        val roadCount = targets[1]
        val startCity = targets[2]
        val endCity = targets[3]

        // initialize
        val nextCities: MutableList<MutableList<Int>> = mutableListOf()
        val visited: MutableList<Boolean> = mutableListOf()
        repeat(cityCount) {
            nextCities.add(mutableListOf())
            visited.add(false)
        }

        // read road map
        repeat(roadCount) {
            val se = readIntArray()
            nextCities[se[0]].add(se[1])
            nextCities[se[1]].add(se[0])
        }

        // find path
        var found = false
        val queue = ArrayDeque<Int>()
        queue.add(startCity)
        queue.add(-1)
        var counter = 0
        while (!(found or queue.isEmpty())) {
            val city = queue.pop()
            when (city) {
                -1 -> ++counter
                endCity -> found = true
                else -> {
                    visited[city] = true
                    nextCities[city]
                            .filterNot { visited[it] }
                            .forEach { queue.push(it) }
                    queue.push(-1)
                }
            }
        }

        // print result
        if (found) println("YES $counter") else println("NO")
    }
}