fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'X') {
                    try {
                        // east
                        if (input[y][x + 1] == 'M' && input[y][x + 2] == 'A' && input[y][x + 3] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        // west
                        if (input[y][x - 1] == 'M' && input[y][x - 2] == 'A' && input[y][x - 3] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        // north
                        if (input[y - 1][x] == 'M' && input[y - 2][x] == 'A' && input[y - 3][x] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        // south
                        if (input[y + 1][x] == 'M' && input[y + 2][x] == 'A' && input[y + 3][x] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        // north east
                        if (input[y - 1][x + 1] == 'M' && input[y - 2][x + 2] == 'A' && input[y - 3][x + 3] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        // north west
                        if (input[y - 1][x - 1] == 'M' && input[y - 2][x - 2] == 'A' && input[y - 3][x - 3] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        // south east
                        if (input[y + 1][x + 1] == 'M' && input[y + 2][x + 2] == 'A' && input[y + 3][x + 3] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        //south west
                        if (input[y + 1][x - 1] == 'M' && input[y + 2][x - 2] == 'A' && input[y + 3][x - 3] == 'S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                }
            }
        }

        return count
    }

    fun part2(input: List<String>): Int {
        var count = 0
        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'A') {
                    try {
                        /*
                        M.M
                        .A.
                        S.S
                         */
                        if (input[y-1][x - 1] == 'M' && input[y-1][x+1] == 'M' && input[y+1][x-1] == 'S' && input[y+1][x+1]=='S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        /*
                        S.M
                        .A.
                        S.M
                         */
                        if (input[y-1][x - 1] == 'S' && input[y-1][x+1] == 'M' && input[y+1][x-1] == 'S' && input[y+1][x+1]=='M') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        /*
                        S.S
                        .A.
                        M.M
                         */
                        if (input[y-1][x - 1] == 'S' && input[y-1][x+1] == 'S' && input[y+1][x-1] == 'M' && input[y+1][x+1]=='M') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                    try {
                        /*
                        M.S
                        .A.
                        M.S
                         */
                        if (input[y-1][x - 1] == 'M' && input[y-1][x+1] == 'S' && input[y+1][x-1] == 'M' && input[y+1][x+1]=='S') count++
                    } catch (ex: IndexOutOfBoundsException) {
                    }
                }
            }
        }

        return count
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
