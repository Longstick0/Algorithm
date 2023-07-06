package coridingtest

import kotlin.math.max

fun main() {}

class ArrayCut {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        for (i in left..right) {
            val max = max(i / n, i % n) + 1
            answer.add(max.toInt())
        }
        return answer.toIntArray()
    }
}