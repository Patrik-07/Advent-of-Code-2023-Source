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

  val cubes = mutableListOf<Pair<String, Int>>()

  for (set in sets) {
      val cubeCounts = set.split(",").map { it.trim() }
      for (cubeCount in cubeCounts) {
          val cube = cubeCount.split(" ")
          cubes.add(Pair(cube[1], cube[0].toInt()))
      }
  }

  val cubeCounts = mutableMapOf("red" to red, "green" to green, "blue" to blue)

  return isCubeCountsPossible(cubes, cubeCounts)
}

fun isCubeCountsPossible(cubes: MutableList<Pair<String, Int>>, cubeCounts: MutableMap<String, Int>): Boolean {
  for (cube in cubes) {
      val expectedCubeCount = cubeCounts[cube.first]
      val actualCubeCount = cube.second

      if (actualCubeCount > expectedCubeCount!!) {
          return false
      }
  }

  return true
}