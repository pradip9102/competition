package codechef.ch1804b

class HighwayC {
}

fun main(args: Array<String>) {
    fun readIntList(delimiter: String = " "): List<Int> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (0 until readLine()!!.toInt()).forEach {
        val line1 = readIntList()
        val nLanes = line1[0]
        val walkingSpeed = line1[1]
        val laneWidth = line1[2]

        val carVelocities = readIntList()
        val carDirections = readIntList()
        val initialPositions = readIntList()
        val carLengths = readIntList()
        val chefPos = 0.0

        val timeRequiredToCrossLane = laneWidth.toDouble() / walkingSpeed
        var currTime = 0.0
        (0 until nLanes).forEach { i ->
            // calculate car's distance from chef; also calculate the time to enter and leave the chef's position
            val direction = if (carDirections[i] == 1) 1 else -1
            val distanceFromFront = chefPos - initialPositions[i].toDouble()
            val distanceFromBack: Double = distanceFromFront + (direction * carLengths[i])
            val timeToEnter: Double = direction * distanceFromFront / carVelocities[i]
            val timeToLeave: Double = direction * distanceFromBack / carVelocities[i]

            if (timeToEnter < 0 && timeToLeave < 0) {
                // car is going away from chef and not going to cross ever; chef can cross the road safely
                currTime += timeRequiredToCrossLane
            } else if (timeToEnter < 0) {
                // car starts off from in front of chef
                currTime += if (currTime > timeToLeave) {
                    // car has already left
                    timeRequiredToCrossLane
                } else {
                    // wait till car passes
                    (timeToLeave - currTime) + timeRequiredToCrossLane
                }
            } else if (timeToLeave < 0) {
                println("Error: Car is travelling backward!")
            } else {
                // car started off somewhere else
                currTime += when {
                    (currTime + timeRequiredToCrossLane) < timeToEnter ->
                        // chef has enough time to cross the lane before car comes
                        timeRequiredToCrossLane
                    timeToLeave < currTime ->
                        // chef can cross now, as car has already left
                        timeRequiredToCrossLane
                    else ->
                        // chef has to wait until car passes to safely cross the road
                        (timeToLeave - currTime) + timeRequiredToCrossLane
                }
            }
        }

        println(currTime)
    }
}