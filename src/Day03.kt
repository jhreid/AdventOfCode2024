fun main() {
    fun part1(input: List<String>): Int {
        val regex = "mul\\((\\d+),(\\d+)\\)".toRegex()
        val result = input.map { line ->
            regex.findAll(line).toList().map {
                val (x, y) = it.destructured
                x.toInt() * y.toInt()
            }.sum()
        }.sum()

        return result
    }

    fun part2(input: List<String>): Int {
        val lines = mutableListOf<String>()
        val regex = "mul\\((\\d+),(\\d+)\\)".toRegex()
        var enabled = true
        input.forEach { line ->
            for (i in 0 until line.length) {
                if (i < line.length - 7 && line.substring(i, i + 7) == "don't()") enabled = false
                if (i < line.length - 4 && line.substring(i, i + 4) == "do()") enabled = true
                if (enabled && i < line.length - 4 && line.substring(i, i + 4) == "mul(") {
                    val mul = line.substring(i, line.indexOf(')', i) + 1)
                    if (mul.matches(regex)) {
                        lines.add(mul)
                    }
                }
            }
        }

        val result = lines.map { line ->
            regex.findAll(line).toList().map {
                val (x, y) = it.destructured
                x.toInt() * y.toInt()
            }.sum()
        }.sum()

        return result
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 0)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
