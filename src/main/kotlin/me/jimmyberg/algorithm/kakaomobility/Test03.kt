package me.jimmyberg.algorithm.kakaomobility

fun main() {
    Test03().solution(2, "1A 2F 1C").also { println(it) }
    Test03().solution(1, "").also { println(it) }
    Test03().solution(22, "1A 3C 2B 20G 5A").also { println(it) }
}

class Test03 {

    fun solution() {
        val answer = 0

        println("answer = $answer")
    }

    fun solution(N: Int, S: String): Int {
        val reservedSeats = S.split(" ").toHashSet()
        var count = 0

        val seats = Array(N + 1) { mutableListOf<String>() }

        fun checkSeat(seats: List<String>, wanted: String): Boolean {
            return seats.joinToString("").toSet().intersect(wanted.toSet()).isEmpty()
        }

        for (row in 1..N) {
            if (!reservedSeats.contains("$row" + "B") && !reservedSeats.contains("$row" + "C") &&
                !reservedSeats.contains("$row" + "D") && !reservedSeats.contains("$row" + "E") &&
                checkSeat(seats[row], "BCDE")
            ) {
                seats[row].add("BCDE")
                count++
            }
            if (!reservedSeats.contains("$row" + "D") && !reservedSeats.contains("$row" + "E") &&
                !reservedSeats.contains("$row" + "F") && !reservedSeats.contains("$row" + "G") &&
                checkSeat(seats[row], "DEFG")
            ) {
                seats[row].add("DEFG")
                count++
            }
            if (!reservedSeats.contains("$row" + "F") && !reservedSeats.contains("$row" + "G") &&
                !reservedSeats.contains("$row" + "H") && !reservedSeats.contains("$row" + "J") &&
                checkSeat(seats[row], "FGHJ")
            ) {
                seats[row].add("FGHJ")
                count++
            }
        }

        return count
    }

    private fun checkSeat(seats: List<String>, wanted: String): Boolean {
        return seats.joinToString("").toSet().intersect(wanted.toSet()).isEmpty()
    }

}