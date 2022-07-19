package codechef.ch1803b

class MinVote_bak(val nMinions: Int = 0,
              val influenceLevels: List<Int> = emptyList()) {
    private val _totalInfluenceLevels = mutableListOf<Long>()
    val totalInfluenceLevels: List<Long>
        get() {
            if (_totalInfluenceLevels.isEmpty()) {
                _totalInfluenceLevels.add(0, influenceLevels[0].toLong())
                (1 until nMinions).forEach { i ->
                    _totalInfluenceLevels.add(i, _totalInfluenceLevels[i - 1] + influenceLevels[i])
                }
            }
            return _totalInfluenceLevels
        }

    fun getInfluenceLevelsBetween(i: Int, j: Int): Long {
        val left: Int
        val right: Int
        if (i < j) {
            left = i
            right = j
        } else {
            left = j
            right = i
        }

        return totalInfluenceLevels[right] - totalInfluenceLevels[left] - influenceLevels[right]
    }
}

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (1..readLine()!!.toInt()).forEach {
        val pMinVote = MinVote_bak(readLine()!!.toInt(), readIntArray())

        val nVotes = IntArray(pMinVote.nMinions, { 0 })
        (0 until pMinVote.nMinions - 1).forEach { i ->
            (i + 1 until pMinVote.nMinions).forEach { j ->
                if (i != j) {
                    if (pMinVote.influenceLevels[j] >= pMinVote.getInfluenceLevelsBetween(i, j)) {
                        ++nVotes[i]
                    }
                    if (pMinVote.influenceLevels[i] >= pMinVote.getInfluenceLevelsBetween(i, j)) {
                        ++nVotes[j]
                    }
                }
            }
        }

        println(nVotes.joinToString(" "))
    }
}