package me.jimmyberg.algorithm.naver

class Challenge03 {

}

fun main() {
//    println(solution(arrayOf("0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90")))
//    println(solution(arrayOf("1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100")))
    println(solution(arrayOf("1901 10 50", "1909 10 50")))
}

fun solution(logs: Array<String>): Array<String> {
    val testerList = mutableListOf<Map.Entry<String, MutableList<String>>>()
    val testerMap = mutableMapOf<String, MutableList<String>>()
    logs.forEach {
        val log = it.split(" ")
        val tester = log[0]
        val score = "${log[1]}=${log[2]}"
        if (testerMap[tester] == null) {
            testerMap[tester] = mutableListOf(score)
        } else {
            testerMap[tester]!!.add(score)
        }
    }
    testerMap.forEach { testerList.add(it) }

    val answer = mutableListOf<String>()
    for (i in 0 until testerList.size) {
        val sTester = testerList[i].value
        for (j in i + 1 until testerList.size) {
            val tTester = testerList[j].value
            val tTestLen = tTester.size
            var dupTest = 0
            tTester.forEach {
                if (sTester.contains(it)) {
                    dupTest++
                }
            }

            if (tTestLen >= 5 && tTestLen.equals(dupTest)) {
                answer.add(testerList[i].key)
                answer.add(testerList[j].key)
            }
        }
    }
    return if (answer.size == 0) {
        arrayOf("None")
    } else {
        answer.sorted().toSet().toTypedArray()
    }
}