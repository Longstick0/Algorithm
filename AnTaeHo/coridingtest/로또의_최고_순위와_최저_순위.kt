package coridingtest

fun main() {



    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        return intArrayOf(
            7 - lottos.filter{ win_nums.contains(it) || it == 0 }.size,
            7 - lottos.filter{ win_nums.contains(it) }.size
        ).map{ if(it > 6) 6 else it }.toIntArray()
    }
}

