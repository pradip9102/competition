package codechef.sghc2018

import java.util.*

class LGoodSub {
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    for (t in 0 until scanner.nextInt()) {
        val n = scanner.nextInt()
        val max = ArrayList<Int>(n)
        val array = ArrayList<Int>(n)
        for (i in 0 until n) {
            array.add(scanner.nextInt())
            max.add(if (i == 0 || array[i] > array[max[i - 1]]) i else max[i - 1])
        }

        var maxLen = 1
        for (j in array.indices) {
            var i = max[j]
            while (i < j && array[i] >= array[j]) {
                val len = j - i + 1
                if (maxLen < len) {
                    maxLen = len
                }
                if (i > 0 && array[max[i-1]] >= array[j]) {
                    i = max[i - 1]
                } else {
                    break
                }
            }
        }
        println(maxLen)
    }
}