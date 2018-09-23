package codechef.ch1802

class Chefchr {
    companion object {
        fun countLovely(str: String): Int {
            if (str.length < 4) return 0

            val target = 'c'.toInt() + 'h'.toInt() + 'e'.toInt() + 'f'.toInt()
            //println(str.substring((i - 3)..i))
            return (3 until str.length)
                    .map { str[it].toInt() + str[it - 1].toInt() + str[it - 2].toInt() + str[it - 3].toInt() }
                    .filter { target == it }
                    .onEach { println(it) }
                    .count()
        }
    }
}

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach { t ->
        val str = readLine()!!//.replace("(.)\\1+", "$1")
        val result = Regex("[^chef]+")
                .split(str)
                .filter { it.isNotEmpty() }
                .filter { it.length >= 4 }
                .map { Chefchr.countLovely(it) }
                .sum()
        println(if (result == 0) "normal" else "lovely $result")
    }
}