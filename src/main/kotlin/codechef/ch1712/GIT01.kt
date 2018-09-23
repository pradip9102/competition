package codechef.ch1712

class GIT01 {
}

fun main(args: Array<String>) {
    val nTest = readLine()!!.toInt()
    for (t in 0 until nTest) {
        val dimension = readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }

        val nRow = dimension[0]
        val nColumn = dimension[1]

        var rfCost = 0
        var gfCost = 0
        for (n in 0 until nRow) {
            val row = readLine()!!
            for (m in 0 until nColumn) {
                if ((m + n) % 2 == 0) {
                    // in even position
                    when (row[m]) {
                        'R' -> gfCost += 5
                        'G' -> rfCost += 3
                        else -> throw IllegalArgumentException("Invalid input!")
                    }
                } else {
                    // in odd position
                    when (row[m]) {
                        'R' -> rfCost += 5
                        'G' -> gfCost += 3
                        else -> throw IllegalArgumentException("Invalid input!")
                    }
                }
            }
        }

        println(if (rfCost < gfCost) rfCost else gfCost)
    }
}