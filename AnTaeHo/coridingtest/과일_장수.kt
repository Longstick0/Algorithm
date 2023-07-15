package coridingtest

import java.util.Stack

fun main() {

}

class Fruit {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()

        score.sort()
        for (i in score) {
            stack.push(i)
        }

        while (stack.size >= m) {
            for (i in 0 until m-1) {
                stack.pop()
            }
            answer += stack.pop() * m
        }
        return answer
    }
}