//package codechef.ch1712

class VK18 {
    private val diamondsInHouse = arrayOfNulls<Long>(1_000_005)

    private fun getDiamondsInRoom(roomNumber: Int): Long {
        var diamonds = 0L
        roomNumber.toString()
                .map { it.toString().toInt() }
                .forEachIndexed { index, digit ->
                    if (index % 2 == 0) {
                        diamonds += digit
                    } else {
                        diamonds -= digit
                    }
                }

        return Math.abs(diamonds)
    }

    fun getDiamondsInHouse(dimension: Int): Long {
        if (diamondsInHouse[dimension] == null) {
            var roomNumber = 2
            diamondsInHouse[dimension] =
                    (1..dimension).map { it * getDiamondsInRoom(roomNumber++) }.sum() + ((dimension - 1) downTo 1).map { it * getDiamondsInRoom(roomNumber++) }.sum()
        }

        return diamondsInHouse[dimension]!!
    }
}

fun main() {
    val problem = VK18()
    for (t in 0 until readLine()!!.toInt()) {
        println(problem.getDiamondsInHouse(readLine()!!.toInt()))
    }
}