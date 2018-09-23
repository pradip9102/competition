package hackerearth.zscalar

class RoundTableMeeting {
    private val _N: Int
    private val _Q: Int
    private val _A: List<Int>

    init {
        val line1 = readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
        _N = line1[0]
        _Q = line1[1]

        _A = readLine()!!
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
    }

    private fun getAbsoluteDistance(i: Int, j: Int): Int {
        val temp = Math.abs(i - j)
        val d1 = if (temp >= 0) temp else (_N + temp)
        val d2 = _N - d1
        return if (d1 < d2) d1 else d2
    }

    fun solve() {
        (1.._Q).forEach {
            val line = readLine()!!
                    .split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }
            val x = line[0]
            val y = line[1]

            val xi = (0 until _N).filter { i -> _A[i] == x }
            val yj = (0 until _N).filter { i -> _A[i] == y }

            var globalMin = _N
            xi.forEach { i ->
                yj.forEach { j ->
                    val localMin = getAbsoluteDistance(i, j)
                    if (localMin < globalMin) {
                        globalMin = localMin
                    }
                }
            }

            println(Math.floor(globalMin.toDouble() / 2).toInt())
        }
    }
}

fun main(args: Array<String>) {
    val problem = RoundTableMeeting()
    problem.solve()
}