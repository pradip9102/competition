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

fun main(args: Array<String>) {
    val chanoq = Chanoq()
    (0 until readLine()!!.toInt()).forEach { t ->
        val segments = (0 until readLine()!!.toInt()).map { n ->
            val line = readLine()!!.split(" ").filter { it.isNotEmpty() }
            Segment(line[0].toInt(), line[1].toInt())
        }

        (0 until readLine()!!.toInt()).forEach { q ->
            val points = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
            println(segments.filter { chanoq.isGood(it, points.subList(1, points.size)) }.count())
        }
    }
}