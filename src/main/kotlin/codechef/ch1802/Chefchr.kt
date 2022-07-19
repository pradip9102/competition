package codechef.ch1802

class Chefchr {
    companion object {
        fun countLovely(str: String): Int {
            if (str.length < 4) return 0

            val target = 'c'.code + 'h'.code + 'e'.code + 'f'.code
            //println(str.substring((i - 3)..i))
            return (3 until str.length)
                    .map { str[it].code + str[it - 1].code + str[it - 2].code + str[it - 3].code }
                    .filter { target == it }
                    .onEach { println(it) }
                    .count()
        }
    }
}

fun main() {
    repeat(readLine()!!.toInt()) {
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