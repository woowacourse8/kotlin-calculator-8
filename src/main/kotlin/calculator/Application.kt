package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("덧셈할 문자열을 입력해 주세요.")

    // 기능 1 : 문자열과 구분자 입력 받기
    val input = Console.readLine()

    if (input == null || input.isEmpty()) {
        println("결과 : 0")
    }

    input.toIntOrNull()?.let { number ->
        println("결과 : $number")
    }
}
