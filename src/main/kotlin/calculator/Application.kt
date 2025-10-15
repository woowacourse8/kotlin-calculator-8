package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")
    var result = 0

    // 기능 1 : 문자열과 구분자 입력 받기
    val input = Console.readLine()

    if (input.isNullOrEmpty()) {
        result = 0
    }

    input.toIntOrNull()?.let { number ->
        result = number
    }

    // 기능 2 : 구분자 분석 및 문자열 분리
    val numbers : List<String>

    if (input.startsWith("//") &&
        input.startsWith("\\n", startIndex = 3)){
        val customDelimiter = input[2]
        numbers = input.substring(5).split(",", ":", "$customDelimiter")
    }
    else{
        numbers = input.split(",", ":")
    }

    // 기능 3 : 숫자 변환 및 합계 계산
    // 기능 4 : 예외처리 (음수거나 구분된 문자열이 숫자가 아닐 시 오류)
    for (number in numbers){
        val num = number.toIntOrNull()
        if (num != null && num >= 0){
            result += num
        }
        else{
            throw IllegalArgumentException()
        }
    }
    println("결과 : $result")
}
