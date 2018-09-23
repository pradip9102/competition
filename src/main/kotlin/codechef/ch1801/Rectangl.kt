package codechef.ch1801

class Rectangl {
}

fun main(args: Array<String>) {
    (1..readLine()!!.toInt()).forEach {
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