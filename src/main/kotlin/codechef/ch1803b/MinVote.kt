package codechef.ch1803b

class MinVote(private val nMinion: Int, private val strengths: IntArray) {
//    val totalStrengths = strengths

    init {
//        (1 until nMinion).forEach { i -> totalStrengths[i] = totalStrengths[i - 1] + strengths[i] }
    }

    fun getVotes(): IntArray {
        val votes = IntArray(nMinion, { 0 })
        for (j in (0 until nMinion)) {
            var rsLeft = strengths[j]
            var rsRight = strengths[j]
            for (i in (1 until nMinion)) {
                val li = j - i
                val ri = j + i
                if ((0 <= li) && (rsLeft >= 0)) {
                    // vote the minion at `li`
                    ++votes[li]
                    rsLeft -= strengths[li]
                }
                if ((ri < nMinion) && (rsRight >= 0)) {
                    // vote the minion at `ri`
                    ++votes[ri]
                    rsRight -= strengths[ri]
                }
                if ((rsLeft < 0) && (rsRight < 0)) {
                    // work is done for inner `for` loop
                    break
                }
            }
        }
        return votes
    }
}

fun main(args: Array<String>) {
    fun readIntArray(): IntArray {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    }

    (0 until readLine()!!.toInt()).forEach {
        val pchef = MinVote(readLine()!!.toInt(), readIntArray())
        println(pchef.getVotes().joinToString(" "))
    }
}