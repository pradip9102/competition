package codingame.coderoyale

import java.util.*

enum class StructureType {
    NO_STRUCTURE, BARRACK;

    companion object {
        fun get(structureTypeId: Int) = when (structureTypeId) {
            -1 -> NO_STRUCTURE
            2 -> BARRACK
            else -> throw IllegalArgumentException("Unknown structure type $structureTypeId!!")
        }
    }
}

enum class OwnerType {
    NO_OWNER, FRIENDLY, ENEMY;

    companion object {
        fun get(ownerTypeId: Int) = when (ownerTypeId) {
            -1 -> NO_OWNER
            0 -> FRIENDLY
            1 -> ENEMY
            else -> throw IllegalArgumentException("Unknow owner type $ownerTypeId!!")
        }
    }
}

enum class CreepType {
    NO_CREEP, KNIGHT, ARCHER, GIANT;

    companion object {
        fun get(creepTypeId: Int) = when (creepTypeId) {
            0 -> KNIGHT
            1 -> ARCHER
            else -> throw IllegalArgumentException("Unknown creep type $creepTypeId!!")
        }
    }
}

enum class Command {
    WAIT, // WAIT
    MOVE, // MOVE x y
    BUILD, // BUILD {siteId} BARRACKS-{type}
    TRAIN // TRAIN {siteId{ siteId{...}}}
}

data class Field(
        val width: Int = 1920,
        val length: Int = 1000
)

data class Site(
        val siteId: Int,
        val x: Int,
        val y: Int,
        val radius: Int
)

data class Building(
        val siteId: Int,
        val ignore1: Int,
        val ignore2: Int,
        val structureType: StructureType,
        val ownerType: OwnerType,
        val turnsBeforeTraining: Int,
        val creepType: CreepType
)

data class Creep(
        var x: Int,
        var y: Int,
        val ownerType: OwnerType,
        val creepType: CreepType,
        var hp: Int
)

class Barrack(val creepType: CreepType) {
    var isTraining = false
    val trainingCost = when (creepType) {
        CreepType.KNIGHT -> 80
        CreepType.ARCHER -> 100
        else -> Int.MAX_VALUE
    }
    val trainingCapacity = when (creepType) {
        CreepType.KNIGHT -> 4
        CreepType.ARCHER -> 2
        else -> 0
    }
}

class Queen(var touchedSite: Int = -1) {
    val radius = 30
    val max_speed = 60

    val total_health_point = 100
}

class Player() {
    val total_gold = 100

    private val gain_speed = 10
    var remGold = total_gold

    fun gain() {
        remGold += gain_speed
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // initialisation
    val numSites = scanner.nextInt()
    val sites = (0 until numSites).map { Site(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()) }

    // each game turn
    while (true) {
        val gold = scanner.nextInt()
        val touchedSite = scanner.nextInt()
        val buildings = (0 until numSites).map { Building(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), StructureType.get(scanner.nextInt()), OwnerType.get(scanner.nextInt()), scanner.nextInt(), CreepType.get(scanner.nextInt())) }
        val numUnits = scanner.nextInt()
        val creeps = (0 until numUnits).map { Creep(scanner.nextInt(), scanner.nextInt(), OwnerType.get(scanner.nextInt()), CreepType.get(scanner.nextInt()), scanner.nextInt()) }
    }
}