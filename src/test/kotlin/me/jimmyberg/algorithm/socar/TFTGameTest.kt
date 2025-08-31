package me.jimmyberg.algorithm.socar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TFTGameTest {

    /**
     * 1. tickets 의 종류와 가격을 HashMap 형식으로 정리
     * 2. shop 의 갯수의 원소별 갯수를 파악
     * 3. shop 의 모든 원소를 직렬화
     * 4. shop 의 원소 loop 하면서, 동일한 ticket 수집 & 가격 합산, 만약 row 행 넘어가면 `+10` 추가
     */
    private fun solution(tickets: Array<String>, roll: Int, shop: Array<Array<String>>, money: Int): Int {
        // tickets 종류 & 가격 정리
        val ticketsMap = mutableMapOf<String, Int>()
        tickets.forEach {
            val ticket = it.split(" ")
            val name = ticket[0]
            val price = ticket[1].toInt()
            ticketsMap[name] = price
        }
        println("ticketsMap = $ticketsMap")

        // shop 의 행 갯수와 원소별 갯수 파악
        val shopRowSize = shop.mapIndexed { i, s -> s.size * (i + 1) }
        println("shopRowSize = $shopRowSize")

        // shop 모든 원소 직렬화
        val shopSerialize = mutableListOf<String>()
        shop.forEach {
            shopSerialize += it
        }
        println("shopSerialize = $shopSerialize")

        // shopSerialize 티켓별 가격 합산
        var row = 0
        val totalTickets = mutableMapOf<String, MutableList<Int>>()
        shopSerialize.forEachIndexed { i, t ->
            totalTickets.putIfAbsent(t, mutableListOf(0, 0, 0))

            val totalTicket = totalTickets[t]!!
            totalTicket[0] = totalTicket[0] + ticketsMap[t]!!
            totalTicket[1] = row
            totalTicket[2] = totalTicket[2] + 1

            if (i == shopRowSize[row] - 1) {
                row += 1
            }
        }

        println("totalTickets = $totalTickets")

        // totalTickets 정렬
        val sortedTickets = totalTickets
            .toList()
            .sortedBy { it.second[0] }
            .map { it.second }
        println("sorted.totalTickets = $sortedTickets")

        var totalPrice = 0
        var totalCount = 0
        for (i in sortedTickets.indices) {
            val it = sortedTickets[i]
            val price = it[0] + (it[1] * roll)
            if (money <= totalPrice + price) {
                break
            }
            totalPrice += price
            totalCount += it[2]
        }

        println("totalPrice = $totalPrice")
        println("totalCount = $totalCount")

        return totalCount / 3
    }

    @Test
    fun `TFT 게임1 테스트를 시작합니다`() {
    	// given
    	val tickets = arrayOf("A 1", "B 2", "C 5", "D 3")
        val roll = 10
        val shop = arrayOf(arrayOf("B", "C", "B", "C"), arrayOf("A", "A", "A", "B"), arrayOf("D", "D", "C", "D"))
        val money = 30

    	// when
        val result = solution(tickets, roll, shop, money)

    	// then
        assertEquals(2, result)
    }

    @Test
    fun `TFT 게임2 테스트를 시작합니다`() {
    	// given
    	val tickets = arrayOf("A 1", "B 2", "C 5", "D 3")
        val roll = 10
        val shop = arrayOf(arrayOf("B", "C", "B", "C"), arrayOf("A", "A", "A", "B"), arrayOf("D", "D", "C", "D"))
        val money = 100

    	// when
        val result = solution(tickets, roll, shop, money)

    	// then
        assertEquals(4, result)
    }

}
