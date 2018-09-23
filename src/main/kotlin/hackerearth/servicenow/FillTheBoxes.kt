package hackerearth.servicenow

import java.util.*

class FillTheBoxes {
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    (0 until scanner.nextInt()).forEach { _ ->
        val boxCount = scanner.nextInt()
        val ballCount = scanner.nextInt()
        val tolerance = scanner.nextInt()
        val capacities = arrayListOf<Int>()
        val weights = arrayListOf<Int>()

        for (i in 1..boxCount) {
            capacities.add(scanner.nextInt())
        }
        for (i in 1..ballCount) {
            weights.add(scanner.nextInt())
        }

        capacities.sort()
        weights.sort()

        var boxIndex = 0
        var ballIndex = 0
        var filledBoxCount = 0;
        while (boxIndex < boxCount && ballIndex < ballCount) {
            if ((capacities[boxIndex] <= weights[ballIndex]) && (weights[ballIndex] <= capacities[boxIndex] + tolerance)) {
                ++filledBoxCount
                ++ballIndex
                ++boxIndex
            } else if (capacities[boxIndex] > weights[ballIndex]) {
                ++ballIndex
            } else if (weights[ballIndex] > capacities[boxIndex] + tolerance) {
                ++boxIndex
            }
        }

        println(filledBoxCount)
    }
}