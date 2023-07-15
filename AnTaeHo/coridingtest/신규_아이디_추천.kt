package coridingtest

import java.lang.StringBuilder

fun main() {
    val ins = Recommend()
    println(ins.solution("...!@BaT#*..y.abcdefghijklm"))
}

class Recommend {
    fun solution(newId: String): String {
        var answer = newId
        val regex = Regex("[a-z0-9-_.]")
        val regex2 = Regex("[.]{2,}")

        answer = answer.lowercase()

        val temp = StringBuilder()
        for (i in answer.indices) {
            if (regex.containsMatchIn(answer[i].toString())) {
                temp.append(answer[i])
            }
        }

        answer = temp.toString().replace(regex2, ".")

        if (answer.isNotEmpty() && answer.first() == '.') {
            answer = answer.removeRange(0, 1)
        }
        if (answer.isNotEmpty() && answer.last() == '.') {
            answer = answer.removeRange(answer.length-1, answer.length)
        }

        if (answer.isEmpty()) {
            answer = "a"
        }

        if (answer.length >= 16) {
            answer = answer.substring(0..14)
        }
        if (answer.isNotEmpty() && answer.last() == '.') {
            answer = answer.removeRange(answer.length-1, answer.length)
        }

        val temp2 = answer.last()
        while(answer.length <= 2) {
            answer += temp2
        }

        return answer
    }
}