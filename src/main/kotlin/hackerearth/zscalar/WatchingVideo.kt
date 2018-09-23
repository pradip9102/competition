package hackerearth.zscalar

class WatchingVideo {
    private val _N: Int
    private val _d: Int
    private val avgReceivedPackets = mutableListOf(0.0)

    init {
        val line1 = readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
        _N = line1[0]
        _d = line1[1]

        readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
                .forEachIndexed { i, size ->
                    run {
                        avgReceivedPackets.add(if (i == 0) {
                            size.toDouble()
                        } else {
                            (avgReceivedPackets[i].toDouble() * (i.toDouble() / (i + 1).toDouble())) + (size.toDouble() / (i + 1).toDouble())
                        })
                    }
                }
    }

    fun solve() {
        var playAt = _N
        for (i in _N downTo 1) {
            if (avgReceivedPackets[i] >= _d) {
                playAt = i
            } else {
                break
            }
        }
        println(playAt - 1)
    }
}

fun main(args: Array<String>) {
    val problem = WatchingVideo()
    problem.solve()
}