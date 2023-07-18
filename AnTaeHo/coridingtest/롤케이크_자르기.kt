package coridingtest

fun main() {

}

class Cake {
    fun solution(topping: IntArray): Int {
        var answer = 0
        val upper = HashSet<Int>()
        val lower = HashSet<Int>()
        val toppingCount = mutableMapOf<Int, Int>()

        topping.forEach {
            lower.add(it)
            toppingCount[it] = toppingCount.getOrDefault(it, 0) + 1
        }

        for (i in topping.indices) {
            upper.add(topping[i])
            toppingCount[topping[i]] = toppingCount.getOrDefault(topping[i], 0) - 1
            if (toppingCount.getOrDefault(topping[i], 0) <= 0)
                lower.remove(topping[i])
            if (upper.size == lower.size) answer++
        }
        return answer
    }
}