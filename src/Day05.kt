import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        val orders = input.filter { it.contains('|') }.map { it.split('|') }
        val updates = input.filter { it.contains(',') }

        val correct = updates.filter { line ->
            var good = true
            orders.forEach { order ->
                if (line.contains(order[1]) && line.indexOf(order[0]) > line.indexOf(order[1])) {
                    good = false
                }
            }
            good
        }.map { it.split(',') }.map { it[it.size / 2].toInt() }.sum()
        return correct
    }

    fun part2(input: List<String>): Int {
        val orders = input.filter { it.contains('|') }.map { it.split('|') }
        val updates = input.filter { it.contains(',') }

        val orderComparator = Comparator { a: String, b: String ->
                val ordering = orders.filter { it[0] == b && it[1] == a }
                if (ordering.isNotEmpty()) -1 else 0
        }

        val badlines = updates.filter { line ->
            var bad = false
            orders.forEach { order ->
                if (line.contains(order[1]) && line.indexOf(order[0]) > line.indexOf(order[1])) {
                    bad = true
                }
            }
            bad
        }.map { it.split(',').toMutableList().sortedWith(orderComparator) }
            .map { it[it.size / 2].toInt() }.sum()
        return badlines
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 143)
    check(part2(testInput) == 123)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
