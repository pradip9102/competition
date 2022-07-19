//package codechef.ch1712

class CPLAY {
    fun getWinner(shots: String): Int {
        var i = 0
        var winA = 0
        var winB = 0

        // turn 1
        winA += if (shots[i++] == '1') 1 else 0
        winB += if (shots[i++] == '1') 1 else 0
        // turn 2
        winA += if (shots[i++] == '1') 1 else 0
        winB += if (shots[i++] == '1') 1 else 0
        // turn 3
        winA += if (shots[i++] == '1') 1 else 0
        winB += if (shots[i++] == '1') 1 else 0
        if (winA > (winB + 2)) return +i
        else if (winB > (winA + 2)) return -i

        // turn 4
        winA += if (shots[i++] == '1') 1 else 0
        if (winA > (winB + 2)) return +i
        else if (winB > (winA + 1)) return -i
        winB += if (shots[i++] == '1') 1 else 0
        if (winA > (winB + 1)) return +i
        else if (winB > (winA + 1)) return -i

        // turn 5
        winA += if (shots[i++] == '1') 1 else 0
        if (winA > (winB + 1)) return +i
        else if (winB > winA) return -i
        winB += if (shots[i++] == '1') 1 else 0
        if (winA > winB) return +i
        else if (winB > winA) return -i

        while (i < shots.length) {
            winA = if (shots[i++] == '1') 1 else 0
            winB = if (shots[i++] == '1') 1 else 0
            if (winA != winB) return if (winA > winB) +i else -i
        }

        return 0
    }
}

fun main() {
    val game = CPLAY()
    while (true) {
        val turn = readLine() ?: return
        val winningShot = game.getWinner(turn)
        println(
                when {
                    winningShot > 0 -> "TEAM-A $winningShot"
                    winningShot < 0 -> "TEAM-B ${-winningShot}"
                    else -> "TIE"
                }
        )
    }
}