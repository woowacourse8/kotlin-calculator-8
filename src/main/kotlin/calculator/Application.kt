package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val inputParser = InputParser()

    val stringCalculator = StringCalculator(inputParser)

    val input = inputView.readInput()
    val result = stringCalculator.add(input)
    resultView.printResult(result)
}

// --- 입출력 ---
class InputView {
    fun readInput(): String? {
        println("덧셈할 문자열을 입력해 주세요.")
        return Console.readLine()
    }
}

class ResultView {
    fun printResult(result: Int){
        println("결과 : $result")
    }
}

// --- 문자열 계산기 ---
class StringCalculator(private val parser: InputParser) {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }

        input.toIntOrNull()?.let {
            return PositiveNumber(it).value
        }

        val numbers = parser.parse(input)

        return numbers.sum()
    }
}

// --- 문자열 파서 ---
class InputParser {
    private val customDelimiterPrefix = "//"
    private val customDelimiterSuffix = "\\n"

    fun parse(input: String): Numbers {
        val stringNumbers = splitInput(input)

        val positiveNumbers = stringNumbers.map {
            val num = it.toIntOrNull()
                ?: throw IllegalArgumentException()
            PositiveNumber(num)
        }
        return Numbers(positiveNumbers)
    }

    private fun splitInput(input: String): List<String> {
        if (input.startsWith(customDelimiterPrefix) && input.contains(customDelimiterSuffix)){
            val parts = input.split(customDelimiterSuffix, limit = 2)
            val customDelimiter = parts[0].substring(customDelimiterPrefix.length)
            return parts[1].split(",", ":", customDelimiter)
        }

        return input.split(",", ":")
    }
}

@JvmInline
value class PositiveNumber(val value: Int) {
    init {
        require(value >= 0)
    }
}

class Numbers(private val values: List<PositiveNumber>) {
    fun sum(): Int {
        return values.sumOf { it.value }
    }
}