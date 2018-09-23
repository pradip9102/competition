package codechef.ch1804b

enum class WorkerType(val typeId: Int) {
    TRANSLATOR(1),
    AUTHOR(2),
    AUTHOR_TRANSLATOR(3);
}

class ChefWork {
}

fun main(args: Array<String>) {
    fun readIntList(delimiter: String = " "): List<Int> {
        return readLine()!!.split(delimiter).filter { it.isNotEmpty() }.map { it.toInt() }
    }

    val nWorker = readLine()!!.toInt()
    val coins = readIntList()
    val workerTypes = readIntList()

    var cheapTranslator = Int.MAX_VALUE
    var cheapAuthor = Int.MAX_VALUE
    var cheapAuthorTranslator = Int.MAX_VALUE
    (0 until nWorker).forEach {
        when (workerTypes[it]) {
            WorkerType.TRANSLATOR.typeId -> if (cheapTranslator > coins[it]) cheapTranslator = coins[it]
            WorkerType.AUTHOR.typeId -> if (cheapAuthor > coins[it]) cheapAuthor = coins[it]
            WorkerType.AUTHOR_TRANSLATOR.typeId -> if (cheapAuthorTranslator > coins[it]) cheapAuthorTranslator = coins[it]
        }
    }

    val costToHireOnePerson = cheapAuthorTranslator
    val costToHireTwoPerson = cheapTranslator + cheapAuthor

    when {
        costToHireOnePerson < 0 -> println(costToHireTwoPerson)
        costToHireTwoPerson < 0 -> println(costToHireOnePerson)
        costToHireOnePerson < costToHireTwoPerson -> println(costToHireOnePerson)
        else -> println(costToHireTwoPerson)
    }
}