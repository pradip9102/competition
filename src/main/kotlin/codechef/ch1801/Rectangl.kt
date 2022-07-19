package codechef.ch1801

fun main() {
    repeat(readLine()!!.toInt()) {
        val lengths = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
        if (lengths[0] == lengths[1] && lengths[2] == lengths[3]) {
            println("YES")
        } else if (lengths[0] == lengths[2] && lengths[1] == lengths[3]) {
            println("YES")
        } else if (lengths[0] == lengths[3] && lengths[1] == lengths[2]) {
            println("YES")
        } else {
            println("NO")
        }
    }
}