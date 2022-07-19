package hackerearth.buyhatke

import java.util.*
import kotlin.collections.ArrayList

class CompoundWord {

    internal var wordDictionary: MutableList<String> = ArrayList()

    internal fun simplify(compoundWord: String, isRoot: Boolean): List<String>? {
        fun join(first: String, remaining: List<String>): List<String> {
            val result = ArrayList<String>()
            result.add(first)
            remaining.forEach { result.add(it) }
            return result
        }

        if (compoundWord.isEmpty()) {
            return emptyList()
        }

        val options = wordDictionary
                .filter { word -> compoundWord.startsWith(word, ignoreCase = true) }
                .map { word -> simplify(compoundWord.substring(word.length), isRoot = false)?.let { join(word, it) } }
                //.onEach { option -> println(option.toString()) }

        return when {
        // we are inside nested call, return null if no options found
            !isRoot -> options.lastOrNull()

        // only one or no options found
            options.size <= 1 -> listOf(compoundWord)

        // otherwise return second last option, as the last option would be combination of longest words (which is the compound word itself)
            else -> options[options.size - 2] ?: listOf(compoundWord)
        }
    }
}

fun main() {
    val s = Scanner(System.`in`)
    val problem = CompoundWord()

    for (i in 0..19) {
        problem.wordDictionary.add(s.next())
    }

    problem.wordDictionary.sort()

    for (word in problem.wordDictionary) {
        println("$word: ${problem.simplify(word, isRoot = true)}")
    }
}
