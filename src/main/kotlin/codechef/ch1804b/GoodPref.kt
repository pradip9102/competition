package codechef.ch1804b

fun main() {
    @Suppress("UNCHECKED_CAST")
    fun <T> readList(delimiter: String = " "): List<T> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it as T }
    }

    repeat(readLine()!!.toInt()) {
        val params = readList<String>()
        val str = params[0]
        var iteration = params[1].toInt()

        var cstr = ""
        val repeatation = mutableListOf<Int>()
        var rc = 1
        if (str.length == 1) {
            cstr += str[0]
            repeatation.add(rc)
        } else {
            (1 until str.length).forEach { i ->
                if (str[i] == str[i - 1]) {
                    ++rc
                } else {
                    cstr += str[i - 1]
                    repeatation.add(rc)
                    rc = 1
                }
            }
        }

        var a = 0L
        var b = 0L
        var count = 0L
        while (0 < iteration--) {
            var temp = 0L
            cstr.forEach {
                when (it) {
                    'a' -> ++a
                    'b' -> ++b
                }

                if (a > b) {
                    ++temp
                }
            }

            count += temp
            if (temp == 0L || temp == str.length.toLong()) {
                count += temp * iteration
                break
            }
        }

        println(count)
    }
}
