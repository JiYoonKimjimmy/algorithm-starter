package me.jimmyberg.algorithm.buketplace

class Test02 {

    /**
     * 문자열 str 이 주어졌을 때, 해당 문자열에 포함된 모음의 순서를 뒤집어 출력한다.
     *
     * - 입력 : bucketplace
     * - 출력 : beckatplecu
     */
    fun solution(str: String): String {
        var answer = ""

        val vowels = mutableListOf<Char>()
        val indexList = findVowels(str)

        for (i in indexList) {
            vowels.add(str[i])
        }

        vowels.reverse()

        for (i in str.indices) {
            answer += if (indexList.contains(i)) {
                vowels.removeAt(0)
            } else {
                str[i]
            }
        }

        return answer
    }

    private fun findVowels(str: String): List<Int> {
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
        val indexList = mutableListOf<Int>()

        for (i in str.indices) {
            if (vowels.contains(str[i].lowercaseChar())) {
                indexList.add(i)
            }
        }

        return indexList
    }

}

fun main() {
    println(Test02().solution("bucketplace"))
    println(Test02().solution("BUCKETPLACE"))
}