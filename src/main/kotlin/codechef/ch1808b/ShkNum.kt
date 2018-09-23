package codechef.ch1808b

import java.util.*

class ShkNum {
    companion object {
        internal fun findPosOfMsb(n: Int): Int {
            var high = 31
            var low = 0
            while (high - low > 1) {
                val mid = (high + low) / 2
                val mask = (1 shl high) - (1 shl mid)
                if (mask and n > 0) {
                    low = mid
                } else {
                    high = mid
                }
            }
            return low
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    (1..scanner.nextInt()).forEach {
        val num = scanner.nextInt()
        val firstMsb = ShkNum.findPosOfMsb(num)
        val secondMsb = ShkNum.findPosOfMsb(num and (1 shl firstMsb).inv())
        var result = -1
        when {
            num == 1 -> result = 2
            num > 1 -> result = if (secondMsb == 0) {
                if (num % 2 == 0) 1 else 0
            } else {
                val min = (1 shl firstMsb) or (1 shl secondMsb)
                val max = (1 shl firstMsb) or (1 shl secondMsb + if (firstMsb - secondMsb > 1) 1 else 2)
                val minDiff = num - min
                val maxDiff = max - num
                if (maxDiff > minDiff) minDiff else maxDiff
            }
            else -> System.err.println("Invalid input: $num")
        }
//        println(Integer.toBinaryString(num) + ": " + firstMsb + ", " + secondMsb)
//        println("result: $result")
        println(result)
    }
}
