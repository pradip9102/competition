package hackerearth.dell

import java.util.*

class OneSwapToPalindrome {
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    (0 until scanner.nextInt()).forEach {
        val str = scanner.next()!!
        var diffCount = 0
        var k1 = 0
        var k2 = 0
        for (i in 0 until (str.length / 2)) {
            val j = str.length - i - 1
            if (str[i] != str[j]) {
                ++diffCount
                k2 = k1
                k1 = i
            }
        }

        when {
            diffCount > 2 -> println("No")
            diffCount == 2 -> {
                if (str[k1] == str[str.length - k2 - 1]
                        && str[k2] == str[str.length - k1 - 1]) {
                    println("Yes")
                } else if (str[k1] == str[k2]
                        && str[str.length - k1 - 1] == str[str.length - k2 - 1]) {
                    println("Yes")
                } else {
                    println("No")
                }
            }
            diffCount == 1 -> {
                if (str.length % 2 == 1) {
                    val mid = (str.length + 1) / 2
                    if (str[k1] == str[mid] || str[str.length - k1 - 1] == str[mid]) {
                        println("Yes")
                    } else {
                        println("No")
                    }
                } else {
                    println("No")
                }
            }
            diffCount == 0 -> {
                println("Yes")
            }
        }
    }
}