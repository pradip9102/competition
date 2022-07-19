package codechef.ch1801

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        val seqs: MutableList<List<Int>> = mutableListOf()
        (1..readLine()!!.toInt()).forEach {
            seqs.add(readIntArray())
        }

        var max = Int.MAX_VALUE
        var result = 0L
        var impossible = false
        seqs.asReversed().forEach seq@{ array ->
            val num = array.maxOrNull()
            if (num != null) {
                max = num
                result += num
            } else {
                impossible = true
                return@seq
            }
        }

        // print result
        println(if (impossible) -1 else result)
        println(max)
    }
}