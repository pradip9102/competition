package codechef.ch1801

class StrMrg {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    fun readInt(): Int {
        return readLine()!!.toInt()
    }

    fun minMergeCount(strA: String, strB: String, startA: Int, startB: Int): Int {
        if (startA >= strA.length && startB >= strB.length) return 0
        if (startA >= strA.length) return strB.length - startB
        if (startB >= strB.length) return strA.length - startA

        return if (strA[startA] == strB[startB]) {
            1 + minMergeCount(strA, strB, startA + 1, startB + 1)
        } else {
            val advA = 1 + minMergeCount(strA, strB, startA + 1, startB)
            val advB = 1 + minMergeCount(strA, strB, startA, startB + 1)
            if (advA < advB) advA else advB
        }
    }

    val t = readInt()
    (1..t).forEach {
        val line1 = readIntArray()
        val n = line1[0]
        val m = line1[1]
        val strA = readLine()!!
        val strB = readLine()!!

        var effA = "".plus(strA[0])
        (1 until strA.length).forEach { i ->
            if (effA.last() != strA[i]) {
                effA = effA.plus(strA[i])
            }
        }

        var effB = "".plus(strB[0])
        (1 until strB.length).forEach { i ->
            if (effB.last() != strB[i]) {
                effB = effB.plus(strB[i])
            }
        }

//        println("strA: $effA\nstrB: $effB")
        println(minMergeCount(effA, effB, 0, 0))
    }
}