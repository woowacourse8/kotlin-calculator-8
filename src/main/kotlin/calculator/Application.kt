package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    while (true){
        println("덧셈할 문자열을 입력해 주세요.")

        // 기능 1 : 문자열과 구분자 입력 받기
        val input = Console.readLine()

        if (input == null || input.isEmpty()) {
            println("결과 : 0")
            break
        }

        input.toIntOrNull()?.let { number ->
            println("결과 : $number")
            break
        }

        // 기능 2 : 구분자 분석 및 문자열 분리
        var numbers : List<String>
        var result = 0

        if (input.startsWith("//") &&
            input.startsWith("\\n", startIndex = 3)){
            val customDelimiter = input[2]
            numbers = input.substring(5).split(",", ":", "$customDelimiter")
        }
        else{
            numbers = input.split(",", ":")
        }

        // 기능 3 : 숫자 변환 및 합계 계산
        for (number in numbers){
            number.toIntOrNull()?.let { num ->
                result += num
            }
        }
        println("결과 : $result")
        break
    }
}
