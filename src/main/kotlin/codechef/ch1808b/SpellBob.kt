package codechef.ch1808b

import java.util.*

class SpellBob {

    companion object {
        internal fun isBobPossible(bList: Set<Int>, oList: Set<Int>): Boolean {
            if (bList.size < 2 || oList.isEmpty()) {
                return false
            }

            if (bList.size > 2 || oList.size > 2) {
                return true
            }

            for (cid in oList) {
                if (!bList.contains(cid)) {
                    return true
                }
            }

            return false
        }
    }
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    for (t in scanner.nextInt() downTo 1) {
        val bList = HashSet<Int>(3)
        val oList = HashSet<Int>(3)

        val front = scanner.next()
        val back = scanner.next()
        for (i in 0 until front.length) {
            if (front[i] == 'b') {
                bList.add(i)
            }
            if (front[i] == 'o') {
                oList.add(i)
            }
            if (back[i] == 'b') {
                bList.add(i)
            }
            if (back[i] == 'o') {
                oList.add(i)
            }
        }

        println(if (SpellBob.isBobPossible(bList, oList)) "yes" else "no")
    }
}
