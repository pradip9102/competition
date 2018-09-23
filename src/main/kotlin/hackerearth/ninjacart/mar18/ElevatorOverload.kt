package hackerearth.ninjacart.mar18

class Elevator(val maxFloor: Int, val maxPerson: Int, val maxWeight: Int) {
    var floor = 1
    var person = 0
    var weight = 0

    fun isOverloaded() = (person > maxPerson) || (weight > maxWeight)
}

fun main(args: Array<String>) {
    fun readIntArray(): IntArray {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    }

    (0 until readLine()!!.toInt()).forEach {
        val maxFloor = readLine()!!.toInt()
        val line2 = readIntArray()
        val elevator = Elevator(maxFloor, line2[0], line2[1])

        val nPersonEntering = readIntArray()
        val nPersonLeaving = IntArray(elevator.maxFloor, { 0 })
        val weightEntering = IntArray(elevator.maxFloor, { 0 })
        val weightLeaving = IntArray(elevator.maxFloor, { 0 })

        (1 until elevator.maxFloor).forEach { currFloor ->
            val desiredFloors = readIntArray()
            val correspondingWeights = readIntArray()

            // if already overloaded, then skip calculation (to optimise)
            if (!elevator.isOverloaded()) {
                // check persons and corresponding weights
                (0 until nPersonEntering[currFloor - 1]).forEach {
                    nPersonLeaving[desiredFloors[it] - 1] += 1
                    weightLeaving[desiredFloors[it] - 1] += correspondingWeights[it]
                    weightEntering[currFloor - 1] += correspondingWeights[it]
                }

                // calculate final status of elevator
                elevator.person += nPersonEntering[currFloor - 1] - nPersonLeaving[currFloor - 1]
                elevator.weight += weightEntering[currFloor - 1] - weightLeaving[currFloor - 1]
            }

            if (!elevator.isOverloaded()) {
                // go to next floor
                ++elevator.floor
            }
        }

        println(elevator.floor)
    }
}