package coridingtest

import kotlin.math.sqrt

fun main() {
    val a = Knight()
    a.solution(5, 5, 5)

}

class Knight {
    fun solution(number: Int, limit: Int, power: Int): Int {
        return (1..number).map { i ->
            val x = (1..sqrt(i.toFloat()).toInt()).filter { i % it == 0 }
            (x + x.map { i / it }).toSet().count()
        }.map {
            if(it > limit) power else it
        }.sumOf { it }
    }
}