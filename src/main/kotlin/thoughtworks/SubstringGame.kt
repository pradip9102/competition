package thoughtworks

class SubstringGame {
}

fun main(args: Array<String>) {
    val str = readLine()!!
    val q = readLine()!!.toInt()
    val maxIndex = if (str.length % 2 == 0) {
        (str.length / 2) * (str.length + 1)
    } else {
        str.length * ((str.length + 1) / 2)
    }

    readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }.forEach { num ->
        if (num > maxIndex) {
            println(-1)
        } else {
            var start = 0
            var substringSize = num.toInt()
            while (true) {
                val diff = str.length - start
                if (substringSize - diff >= 0) {
                    substringSize -= diff
                    ++start
                    continue
                }
                break
            }
            println(str.substring(start, start + substringSize))
        }
    }
}