package topcoder.tutorials

data class Rectangle(val bottomLeftX: Double, val bottomLeftY: Double, val topRightX: Double, val topRightY: Double) {
    constructor(bottomLeftX: Int, bottomLeftY: Int, topRightX: Int, topRightY: Int) : this(bottomLeftX.toDouble(), bottomLeftY.toDouble(), topRightX.toDouble(), topRightY.toDouble())
}

/**
 * Mathematical form of a fraction is a/b
 */
data class Fraction(val numerator: Int, val denominator: Int) {
    override fun toString() = when {
        numerator == 0 && denominator == 0 -> "Undefined"
        denominator == 0 -> "Infinity"
        numerator == 0 -> "0"
        denominator == 1 -> "$numerator"
        else -> "$numerator/$denominator"
    }
}

data class Complex(val real: Int, val imaginary: Int) {
    override fun toString() = when {
        imaginary < 0 -> "$real - i${-imaginary}"
        else -> "$real + i$imaginary"
    }
}

infix fun Complex.add(other: Complex)
        = Complex(this.real + other.real, this.imaginary + other.imaginary)

infix fun Complex.subtract(other: Complex)
        = Complex(this.real - other.real, this.imaginary - other.imaginary)

infix fun Complex.multiply(other: Complex)
        = Complex(this.real * other.real - this.imaginary * other.imaginary, this.real * other.imaginary + this.imaginary * other.real)

private fun Fraction.perform(operation: Char, other: Fraction): Fraction {
    val math = Mathematics()
    val numerator: Int
    val denominator: Int

    when (operation) {
        '+', '-' -> {
            denominator = math.LCM(this.denominator, other.denominator)
            val num1 = this.numerator * (denominator / this.denominator)
            val num2 = other.numerator * (denominator / other.denominator)
            when (operation) {
                '+' -> numerator = num1 + num2
                '-' -> numerator = num1 - num2
                else -> numerator = 0
            }
        }
        '*' -> {
            numerator = this.numerator * other.numerator
            denominator = this.denominator * other.denominator
        }
        '/' -> {
            numerator = this.numerator * other.denominator
            denominator = this.denominator * other.numerator
        }
        else -> throw IllegalArgumentException("Wondering!! What an operation like '$operation' does?")
    }

    val common = math.recursiveGCD(numerator, denominator)
    return Fraction(numerator / common, denominator / common)
}

infix fun Fraction.add(other: Fraction) = this.perform('+', other)
infix fun Fraction.subtract(other: Fraction) = this.perform('-', other)
infix fun Fraction.multiply(other: Fraction) = this.perform('*', other)
infix fun Fraction.divide(other: Fraction) = this.perform('/', other)

class Geometry {

    /**
     * Finds the intersection of two rectangles.
     */
    fun intersection(r1: Rectangle, r2: Rectangle): Rectangle? {
        val r3 =
                Rectangle(maxOf(r1.bottomLeftX, r2.bottomLeftX),
                        maxOf(r1.bottomLeftY, r2.bottomLeftY),
                        minOf(r1.topRightX, r2.topRightX),
                        minOf(r1.topRightY, r2.topRightY))
        return if (r3.bottomLeftX > r3.topRightX || r3.bottomLeftY > r3.topRightY) null else r3
    }

    /**
     * Euler's formula for polygonal nets (a polygonal net is a simple polygon divided into smaller polygons):
     *      V - E + F = 2
     *      V = number of vertices
     *      E = number of edges
     *      F = number of faces
     */
}

fun main() {
    Rectangle(1, 1, 3, 3)
    Rectangle(2, 2, 4, 4)

    val f1 = Fraction(4, 9)
    val f2 = Fraction(1, 6)
    val f3 = Fraction(5, 3)
    println("$f1 + $f2 * $f3 = ${f1 add f2 multiply f3}")
    println("$f1 + ($f2 * $f3) = ${f1 add (f2 multiply f3)}")
    println("($f1 + $f2) * $f3 = ${(f1 add f2) multiply f3}")
}