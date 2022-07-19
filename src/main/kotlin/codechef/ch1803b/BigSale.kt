package codechef.ch1803b

fun main() {
    fun readIntArray(): List<Int> {
        return readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    repeat(readLine()!!.toInt()) {
        val nRecipes = readLine()!!.toInt()
        var totalLoss = 0.0
        repeat(nRecipes) {
            val productDetails = readIntArray()
            val price = productDetails[0]
            val quantity = productDetails[1]
            val discount = productDetails[2]

            totalLoss += 0.0001 * quantity * price * discount * discount
        }

        println(totalLoss)
    }
}