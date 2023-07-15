package coridingtest

import kotlin.math.min


fun main() {

}

class Pair {
    fun solution(X: String, Y: String): String {
        var answer = ""
        for (ch in (9 downTo 0).toList().map { it.toString() }) {
            answer += ch.repeat(min(X.count { it.toString() == ch }, Y.count { it.toString() == ch }))
        }
        if (answer.isEmpty()) answer = "-1"
        if (answer.toList().distinct() == listOf('0')) answer = "0"
        return answer
    }
}