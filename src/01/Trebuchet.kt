fun main() {
    val input = ""

    val calibrationValue = calculateCalibrationValue(input)
    println(calibrationValue)
}

fun calculateCalibrationValue(input: String): Int {
    val calibrationDocument = input.lines()
    var sum = 0

    for (line in calibrationDocument) {
        val firstDigit = line.first { it.isDigit() }.toString().toInt()
        val lastDigit = line.last { it.isDigit() }.toString().toInt()

        sum += (firstDigit * 10 + lastDigit)
    }

    return sum
}