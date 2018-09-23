package codechef.ch1803b

class BigSale {
}

fun main(args: Array<String>) {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    (1..readLine()!!.toInt()).forEach {
        val nRecipes = readLine()!!.toInt()
        var totalLoss = 0.0
        (1..nRecipes).forEach {
            val productDetails = readIntArray()
            val price = productDetails[0]
            val quantity = productDetails[1]
            val discount = productDetails[2]

            totalLoss += 0.0001 * quantity * price * discount * discount
        }

        println(totalLoss)
    }
}