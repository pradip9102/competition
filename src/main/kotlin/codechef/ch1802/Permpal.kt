package codechef.ch1802

import java.util.*

class Permpal(
        private var str: String = readLine()!!
) {

    fun solve(): String {
        var result = ""
        val base = 'a'.code
        val positions = (0..26).map { ArrayDeque<Int>() }
        var oddCount = 0

        str.forEachIndexed { i, ch ->
            val chId = ch.code - base
            if (positions[chId].size % 2 == 0) ++oddCount else --oddCount
            positions[chId].push(i + 1)
        }

        result = compute(oddCount, positions, result)
        return result
    }

    private fun compute(oddCount: Int, positions: List<ArrayDeque<Int>>, result: String): String {
        var result1 = result
        if (oddCount > 1) {
            println(-1)
        } else {
            var ochId: Int = -1

            // print left
            for (i in (0..26)) {
                if (positions[i].size % 2 != 0)
                    ochId = i
                repeat(positions[i].size / 2) {
                    result1 += str[positions[i].peek() - 1]
                    print("${positions[i].pop()} ")
                }
            }

            // print center
            if (ochId != -1) {
                result1 += str[positions[ochId].peek() - 1]
                print("${positions[ochId].pop()} ")
            }

            // print right
            for (i in (26 downTo 0)) {
                while (!positions[i].isEmpty()) {
                    result1 += str[positions[i].peek() - 1]
                    print("${positions[i].pop()}")
                    if (i != 0) print(" ")
                }
            }

            //print(": $result")
            println()
        }
        return result1
    }

    fun solve2(): String {
        var result = ""
        val base = 'a'.code
        val positions = (0..26).map { ArrayDeque<Int>() }
        var oddCount = 0

        str.mapIndexed { _, ch ->
            val chId = ch.code - base
            if (positions[chId].size % 2 == 0) ++oddCount else --oddCount
        }

        str.forEachIndexed { pos, ch ->
            val chId = ch.code - base
            if (positions[chId].size % 2 == 0) ++oddCount else --oddCount
            positions[chId].push(pos + 1)
        }

        result = compute(oddCount, positions, result)
        return result
    }

    fun test() {
        val random = Random()
        str = ""
        for (i in (0 until random.nextInt(10) + 1)) {
            str += (random.nextInt(26) + 'a'.code).toChar()
        }
        println("Problem: $str")
        val result = solve()
        println("Solution: $result")
    }
}

fun main() {
    repeat(readLine()!!.toInt()) {
        val problem = Permpal()
        problem.solve()
//        problem.test()
    }
}