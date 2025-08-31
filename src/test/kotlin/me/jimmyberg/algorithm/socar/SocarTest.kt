package me.jimmyberg.algorithm.socar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * 다음과 같은 문제의 알고리즘 문제를 풀어보자.
 * 먼저 문제를 읽고, 분석한 후에 알고리즘 문제 풀이 순서를 정리해보자
 *
 * - 상점별로 제일 가격이 저렴한 티켓이 2개 이상 있는 경우 모두 구매
 * -
 *
 * TFT(Ticket Finding Tactics) 게임
 * - 게임 목표 : 주어진 자금으로 황금 티켓을 최대한 많이 모으는 것
 * - 게임 행동 규칙
 *  1. 상점에서 일반 티켓 구매
 *  2. 상점 새로고침
 *  3. 동일한 일반 티켓 3개를 황금 티켓 1개로 교환하기
 *
 * - 게임 설명
 *  상점에는 일반 티켓 `m` 개가 진열되어 있습니다. 당신은 티켓의 가격을 지불하여 진열되어있는 티켓 중 원하는 티켓을 구매할 수 있습니다.
 *  또, 일정 금액을 상점에 지불하고 상점을 최대한 `n-1` 번 새로고침할 수 있습니다.
 *  새로고침이란, 상점에 진열 중이던 티켓을 모두 폐기하고 새로운 일반 티켓 `m` 개를 진열하는 행동입니다.
 *
 *  당신은 상점에 진열되는 티켓의 패턴을 분석하여 상점을 새로고침 했을 때 매번 어떤 키텟이 진열될지 예측하는 데 성공했습니다.
 *  당신은 예측한 결과를 바탕으로 황금 티켓을 가장 많이 모을 수 있는 방법으로 자금을 사용하려 합니다.
 *
 *  다음은 상점에서 티켓을 구매하여 황금 티켓을 모으는 예시입니다.
 *
 *  [일반 티켓 종류]
 *  - A 티켓 : 1원
 *  - B 티켓 : 2원
 *  - C 티켓 : 5원
 *  - D 티켓 : 3원
 *
 *  [상점의 티켓 진열 예측]
 *  - 최초 상점 : B, C, B, C
 *  - 두 번째 상점 : A, A, A, B
 *  - 세 번째 상점 : D, D, C, D
 *
 *  일반 티켓의 종류와 상점의 티켓 진열 패턴이 위 표와 같고, 상점 새로고침에 필요한 금액이 10원, 당신에게 주어진 자금이 30원이라고 가정하겠습니다.
 *  최초 상점에서 `B` 티켓 2개를 구매하고, 새로고침 한 뒤, 두 번째 상점에서 `A` 티켓 3개, `B` 티켓 1개를 구매하면
 *  총 `2 * 2 + 10 + 1 * 3 + 2 * 1 = 19` 만큼 자금을 사용해 `A` 티켓 3개, `B` 티켓 3개를 구매할 수 있습니다.
 *  `A` 티켓 3개, `B` 티켓 3개를 황금 티켓 2개로 교환할 수 있으며, 이보다 더 많은 황금 티켓을 모으는 방법은 없습니다.
 *
 *  게임에 등장하는 모든 일반 티켓의 정보가 담긴 문자열 배열 `tickets`, 상점 새로고침에 필요한 금액을 나타내는 정수 `roll`,
 *  상점의 새로고침 예측이 담긴 2차원 문자열 배열 `shop` 과 당신에게 주어진 자금을 나타내는 정수 `money` 가 매개변수로 주어집니다.
 *  이때 모을 수 있는 황금 티켓 개수의 최댓값을 return 하도록 solution 함수를 완성해주세요.
 *
 *  [제한 사항]
 *  - 1 <= `tickets` 길이 <= 1,000
 *  - `tickets` 의 원소는 `"TICKET_NAME TICKET_PRICE"` 형태입니다.
 *  - 1 <= `roll` <= 10,000
 *  - 1 <= `shop` 길이 <= 1,000
 *
 *  [입출력 예]
 *  - tickets : ["A 1", "B 2", "C 5", "D 3"]
 *  - roll : 10
 *  - shop : [["B", "C", "B", "C"], ["A", "A", "A", "B"], ["D", "D", "C", "D"]]
 *  - money : 30
 *  => result : 2
 */
class SocarTest {

    data class Ticket(
        val name: String,
        val price: Int,
        val lines: MutableList<TicketLine> = mutableListOf()
    )

    data class TicketLine(
        val number: Int,
        var count: Int = 0,
        var totalPrice: Int = 0
    ) {
        fun add(price: Int): TicketLine {
            this.count += 1
            this.totalPrice += price
            return this
        }
    }

    private fun List<Ticket>.addTicketLines(name: String, number: Int): Ticket {
        return this
            .find { it.name == name }!!
            .apply { this.lines.addCountAndTotalPrice(number, this.price) }
    }

    private fun MutableList<TicketLine>.addCountAndTotalPrice(number: Int, price: Int): TicketLine {
        return this
            .find { it.number == number } ?: TicketLine(number)
            .apply { this.add(price) }
    }

    private fun solution_ver2(tickets: Array<String>, roll: Int, shop: Array<Array<String>>, money: Int): Int {
        val ticketList = tickets.map {
            val ticket = it.split(" ")
            Ticket(name = ticket[0], price = ticket[1].toInt())
        }

        shop.forEachIndexed { number, store ->
            store.forEach {
                ticketList.addTicketLines(it, number)
            }
        }

        ticketList.forEach(::println)

        return 0
    }

    private fun solution(tickets: Array<String>, roll: Int, shop: Array<Array<String>>, money: Int): Int {
        val ticketsMap = mutableMapOf<String, Int>()
        tickets.forEach {
            val ticket = it.split(" ")
            ticketsMap[ticket[0]] = ticket[1].toInt()
        }
        println("ticketsMap = $ticketsMap")

        val shopMap = mutableListOf<Map<String, MutableList<Int>>>()
        shop.forEach { s ->
            val storeMap = mutableMapOf<String, MutableList<Int>>()
            s.forEach { t ->
                storeMap.putIfAbsent(t, mutableListOf(0, 0))
                val store = storeMap[t]!!
                store[0] += 1
                store[1] += ticketsMap[t]!!
            }
            shopMap += storeMap
        }
        println("shopMap = $shopMap")

        var spendMoney = 0
        var normalTickets = 0
        shopMap.forEach { store ->
            val min = store.minOf { it.value[1] }
            val ticket = store.filter { it.value[1] == min }
            println(ticket)
        }

        println(normalTickets)

        return normalTickets / 3
    }

    @Test
    fun test() {
        val result = solution(
            tickets = arrayOf("A 1", "B 2", "C 5", "D 3"),
            roll = 10,
            shop = arrayOf(arrayOf("B", "C", "B", "C"), arrayOf("A", "A", "A", "B"), arrayOf("D", "D", "C", "D")),
            money = 30
        )
        println(result)
        assertEquals(2, result)
    }

}