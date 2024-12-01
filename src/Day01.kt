import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val pairs = input.map { it.split("   ") }

        val left = pairs.map { it[0].toInt() }.sorted()
        val right = pairs.map { it[1].toInt() }.sorted()

        val apart = left.zip(right){ l, r -> abs(l - r) }
        return apart.sum()
    }

    fun part2(input: List<String>): Int {
        val pairs = input.map { it.split("   ") }

        val left = pairs.map { it[0].toInt() }
        val right = pairs.map { it[1].toInt() }

        val similarity = left.map { l -> l * right.count { it == l }}
        return similarity.sum()
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("1   2")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
