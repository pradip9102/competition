package topcoder.tutorials

/**
 * Primes: A number is prime if it is only divisible by 1 and itself.
 * GCD: The greatest common divisor (GCD) of two numbers a and b is the greatest number that divides evenly into both a and b.
 */
class Mathematics {

    fun isPrime(n: Int) = when {
        n <= 1 -> false     // numbers smaller than 1 are not prime
        n == 2 -> true      // 2 is prime
        n % 2 == 0 -> false // other even numbers are not prime
        else -> {
            val m = Math.sqrt(n.toDouble()).toInt()
            (3..m step 2).none { n % it == 0 }
        }
    }

    /**
     * Sieve algorithm
     */
    fun sievePrime(n: Int): BooleanArray {
        val prime = BooleanArray(n + 1, { true })
        prime[0] = false
        prime[1] = false
        val m = Math.sqrt(n.toDouble()).toInt()
        (2..m)
                .filter { i -> prime[i] }
                .flatMap { j -> (j * j)..n step j }
                .forEach { k -> prime[k] = false }
        return prime
    }

    fun naiveGCD(a: Int, b: Int) = (minOf(a, b) downTo 1).first { a % it == 0 && b % it == 0 }

    /**
     * Euclid's algorithm
     */
    tailrec fun recursiveGCD(a: Int, b: Int): Int = if (b == 0) a else recursiveGCD(b, a % b)

    fun LCM(a: Int, b: Int) = b * a / recursiveGCD(a, b)

    fun multiplyByTen(n: Int) = (n shl 3) + (n shl 1)
}


fun main() {
    val math = Mathematics()
    val num = 59
    println("$num is ${if (math.isPrime(num)) "" else "not "}a prime number.")
    println(math.sievePrime(num).joinToString())

    println(Integer.parseInt("123", 8))
    println(math.multiplyByTen(83))
}