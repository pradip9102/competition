package codechef.proc17

class Prgcup03 {
    companion object {
        val AKIRA = "akira"
        val HIDEKI = "hideki"
        val NOBODY = "drew"
    }
}

enum class Weapon(type: String) {
    SCISSORS("scissors"),
    PAPER("paper"),
    ROCK("rock"),
    MOON("moon"),
    SUN("sun");
}

infix fun Weapon.beats(other: Weapon): Boolean? = when {
    this == Weapon.SCISSORS && other == Weapon.PAPER
            || this == Weapon.PAPER && other == Weapon.ROCK
            || this == Weapon.ROCK && other == Weapon.MOON
            || this == Weapon.MOON && other == Weapon.SUN
            || this == Weapon.SUN && other == Weapon.SCISSORS
            || this == Weapon.SCISSORS && other == Weapon.MOON
            || this == Weapon.MOON && other == Weapon.PAPER
            || this == Weapon.PAPER && other == Weapon.SUN
            || this == Weapon.SUN && other == Weapon.ROCK
            || this == Weapon.ROCK && other == Weapon.SCISSORS -> true
    else -> null
}

fun main(args: Array<String>) {
    (0 until readLine()!!.toInt()).forEach {
        val line = readLine()!!.split(" ")
        val weapon1 = Weapon.valueOf(line[0].toUpperCase())
        val weapon2 = Weapon.valueOf(line[1].toUpperCase())

        if (weapon1 beats weapon2 == true) {
            println(Prgcup03.AKIRA)
        } else if (weapon2 beats weapon1 == true) {
            println(Prgcup03.HIDEKI)
        } else {
            println(Prgcup03.NOBODY)
        }
    }
}