package hackerearth.dell

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

fun main() {
    val scanner = Scanner(System.`in`)
    repeat(scanner.nextInt()) {
        val length = scanner.nextInt()

        val found = HashMap<Int, Boolean>()
        val summedArray = LongArray(length + 1) { 0 }
        for (i in 1..length) {
            val num = scanner.nextInt()
            found[num] = true
            summedArray[i] = summedArray[i - 1] + num.toLong()
        }

        var result = Int.MAX_VALUE
        for (j in 1..length) {
            val leftSum = summedArray[j] - summedArray[0]
            val rightSum = summedArray[length] - summedArray[j]
            val diff = abs(leftSum - rightSum)
            if (found[diff.toInt()] == true && diff < result) {
                //println("$leftSum $rightSum")
                result = diff.toInt()
            }
        }

        println(if (result == Int.MAX_VALUE) -1 else result)
    }
}