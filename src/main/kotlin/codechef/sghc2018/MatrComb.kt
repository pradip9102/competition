package codechef.sghc2018

import java.util.*

class MatrComb {

    companion object {
        fun modInverse(a: Int, m: Int): Int {
            val temp = a % m
            for (x in 1 until m)
                if (temp * x % m == 1)
                    return x
            return 1
        }

        internal fun modDivide(a: Int, b: Int, m: Int): Int {
            val temp = a % m
            val inv = modInverse(b, m)
            return if (inv == -1)
                -1
            else
                inv * temp % m
        }

        fun modFact(n: Int, p: Int): Int {
            // n! % p is 0 if n >= p
            if (p <= n)
                return 0

            // Initialize result as (p-1)! which is -1 or (p-1)
            var res = p - 1

            // Multiply modulo inverse of all numbers from (n+1)
            // to p
            for (i in n + 1 until p)
                res = res * Companion.modInverse(i, p) % p
            return res
        }
    }
}

fun main(args: Array<String>) {
    val limit = 1000000007;
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val numerator = MatrComb.modFact(n * n, limit)
    val denominator = MatrComb.modFact(n + 2, limit) * MatrComb.modFact((n + 1) * (n - 2), limit)
    val result = MatrComb.modDivide(numerator, denominator % limit, limit);
}