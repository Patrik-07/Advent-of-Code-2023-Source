fun main() {
    val redCubes = 12
    val greenCubes = 13
    val blueCubes = 14

    var sumOfPossibleGameIDs = 0

    val input = ""

    for (game in input.lines()) {
        val gameId = game.substringAfter("Game ").substringBefore(":").toInt()
        if (isGamePossible(game, redCubes, greenCubes, blueCubes)) {
            sumOfPossibleGameIDs += gameId
        }
    }

    println(sumOfPossibleGameIDs)
}

fun isGamePossible(line: String, red: Int, green: Int, blue: Int): Boolean {
    val game = line.substringAfter(":")
    val sets = game.split(";")

    val cubes = mutableListOf<Pair<Int, String>>()

    for (set in sets) {
        val cubeCounts = set.split(",").map { it.trim() }
        for (cubeCount in cubeCounts) {
            val cube = cubeCount.split(" ")
            cubes.add(Pair(cube[0].toInt(), cube[1]))
        }
    }

    val cubeCounts = mutableMapOf("red" to red, "green" to green, "blue" to blue)
    for (cube in cubes) {
        val actualCubeCount = cube.first
        val expectedCubeCount = cubeCounts[cube.second]

        if (actualCubeCount > expectedCubeCount!!) {
            return false
        }
    }

    return true
}