package codechef.ch1802

class Chanoq {
    fun isGood(segment: Segment, points: List<Int>): Boolean {
        val count = points
                .filter { segment.li <= it && it <= segment.ri }
                .count()
        return (count and 1) == 1
    }
}

class Segment(val li: Int, val ri: Int)

fun main() {
    val chanoq = Chanoq()
    repeat(readLine()!!.toInt()) {
        val segments = (0 until readLine()!!.toInt()).map { _ ->
            val line = readLine()!!.split(" ").filter { it.isNotEmpty() }
            Segment(line[0].toInt(), line[1].toInt())
        }

        repeat(readLine()!!.toInt()) {
            val points = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
            println(segments.filter { chanoq.isGood(it, points.subList(1, points.size)) }.count())
        }
    }
}