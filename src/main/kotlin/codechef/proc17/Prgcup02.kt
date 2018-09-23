package codechef.proc17

class Prgcup02 {
}

fun main(args: Array<String>) {
    fun gcd(a: Int, b: Int): Int = when {
        a == 0 || b == 0 -> 0
        a == b -> a
        a > b -> gcd(a - b, b)
        else -> gcd(a, b - a)
    }

    (0 until readLine()!!.toInt()).forEach {
        val line1 = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.sorted()
        val x = line1[0]
        val y = line1[1]
        val z = line1[2]

        if ((gcd(x, gcd(y, z)) <= 1) && (x * x + y * y == z * z)) println("YES") else println("NO")
    }
}