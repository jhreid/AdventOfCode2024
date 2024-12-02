import java.lang.Math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val safe = input.map { it.split(" ").map { it.toInt() } }
            .filter { inOrder(it) }
            .filter { noLargeGap(it) }

        return safe.size
    }

    fun part2(input: List<String>): Int {
        val rows = input.map { it.split(" ").map { it.toInt() } }
        val safe = rows.filter { inOrder(it) }
            .filter { noLargeGap(it) }.toMutableSet()

        val unsafe = rows.filterNot { safe.contains(it) }
        unsafe.forEach { row ->
            for (i in 0 until row.size) {
                val subRow = row.filterIndexed { j, _ -> i != j }
                if (inOrder(subRow) && noLargeGap(subRow)) safe.add(row)
                continue
            }
        }

        return safe.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("1 2 3")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun inOrder(input: List<Int>): Boolean = input.sorted() == input || input.sortedDescending() == input

fun noLargeGap(input: List<Int>): Boolean = input.zipWithNext().all { (a, b) -> abs(a - b) > 0 && abs(a - b) < 4 }
