package codechef.ch1802

import java.util.*

class PpChar(
        val ch: Char,
        val origPos: Int,
        val finPos: Int = -1
)

class Permpal(
        private var str: String = readLine()!!
) {

    fun solve(): String {
        var result = ""
        val base = 'a'.toInt()
        val positions = (0..26).map { ArrayDeque<Int>() }
        var oddCount = 0

        str.forEachIndexed { i, ch ->
            val chId = ch.toInt() - base
            if (positions[chId].size % 2 == 0) ++oddCount else --oddCount
            positions[chId].push(i + 1)
        }

        if (oddCount > 1) {
            println(-1)
        } else {
            var ochId: Int = -1

            // print left
            for (i in (0..26)) {
                if (positions[i].size % 2 != 0)
                    ochId = i
                (0 until (positions[i].size / 2)).forEach {
                    result += str[positions[i].peek()-1]
                    print("${positions[i].pop()} ")
                }
            }

            // print center
            if (ochId != -1) {
                result += str[positions[ochId].peek()-1]
                print("${positions[ochId].pop()} ")
            }

            // print right
            for (i in (26 downTo 0)) {
                while (!positions[i].isEmpty()) {
                    result += str[positions[i].peek()-1]
                    print("${positions[i].pop()}")
                    if (i != 0) print(" ")
                }
            }

            //print(": $result")
            println()
        }

        return result
    }

    fun solve2(): String {
        var result = ""
        val base = 'a'.toInt()
        val positions = (0..26).map { ArrayDeque<Int>() }
        var oddCount = 0

        str.mapIndexed { pos, ch ->
            val chId = ch.toInt() - base
            if (positions[chId].size % 2 == 0) ++oddCount else --oddCount
        }

        str.forEachIndexed { pos, ch ->
            val chId = ch.toInt() - base
            if (positions[chId].size % 2 == 0) ++oddCount else --oddCount
            positions[chId].push(pos + 1)
        }

        if (oddCount > 1) {
            println(-1)
        } else {
            var ochId: Int = -1

            // print left
            for (i in (0..26)) {
                if (positions[i].size % 2 != 0)
                    ochId = i
                (0 until (positions[i].size / 2)).forEach {
                    result += str[positions[i].peek()-1]
                    print("${positions[i].pop()} ")
                }
            }

            // print center
            if (ochId != -1) {
                result += str[positions[ochId].peek()-1]
                print("${positions[ochId].pop()} ")
            }

            // print right
            for (i in (26 downTo 0)) {
                while (!positions[i].isEmpty()) {
                    result += str[positions[i].peek()-1]
                    print("${positions[i].pop()}")
                    if (i != 0) print(" ")
                }
            }

            //print(": $result")
            println()
        }

        return result
    }

    fun test() {
        val random = Random()
        str = ""
        for (i in (0 until random.nextInt(10) + 1)) {
            str += (random.nextInt(26) + 'a'.toInt()).toChar()
        }
        println("Problem: $str")
        val result = solve()
        println("Solution: $result")
    }
}

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach { t ->
        val problem = Permpal()
        problem.solve()
//        problem.test()
    }
}