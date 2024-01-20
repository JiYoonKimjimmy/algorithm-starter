package me.jimmyberg.algorithm.buketplace

class Test04 {

    /**
     * 하나의 문자열 `s` 과 문자열 패턴 `pattern` 이 주어졌을 때, 해당 문자가 다음을 만족하면 `true` 반환하고,
     * 그렇지 않으면 `false` 를 반환한다.
     * - 문자열 `s` 에 소문자를 제거하여 `patter` 과 동일한 문자열을 만들 수 있으면 `true` 아니면 `false`
     *
     * - case 1.
     *   - 입력 : s="BucketPlace", patter="BP"
     *   - 출력 : true
     * - case 2.
     *   - 입력 : s="BucketPlace", patter="BuPl"
     *   - 출력 : true
     * - case 3.
     *   - 입력 : s="BucketList", patter="BP"
     *   - 출력 : false
     */
    fun solution(inputs: Array<String>, pattern: String): List<Boolean> {
        return inputs.map {
            it.replace(Regex("[a-z]"), "") == pattern.replace(Regex("[a-z]"), "")
        }
    }

    fun solution2(inputs: Array<String>, pattern: String): List<Boolean> {
        val patternMap = pattern.map { it to it }.toMap()
        return inputs.map {
            it.filter { s -> patternMap.containsKey(s) }.contains(pattern)
        }
    }

    fun isMatch(s: String, pattern: String): Boolean {
        val filteredS = s.filter { pattern.contains(it) }
        return filteredS.contains(pattern)
    }
}

fun main() {
//    println(Test04().solution(arrayOf("BucKetPlace", "BucketList", "BucketPizza"), "BKP"))
//    println(Test04().solution(arrayOf("BucketPlace"), "BuPl"))
//    println(Test04().solution2(arrayOf("BucKetPlace"), "BP"))
    println(Test04().solution(arrayOf("BucJetPlace"), "BJeP"))
    println(Test04().solution2(arrayOf("BucJetPlace"), "BJeP"))
    println(Test04().isMatch("BucJetPlace", "BJeP"))
//    println(Test04().isMatch("BucketList", "BP"))
//    println(Test04().isMatch("BucketPizza", "BP"))
//    println(Test04().isMatch("BucketPlace", "BuPl"))
}