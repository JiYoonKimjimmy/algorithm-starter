package me.jimmyberg.coupang;

import java.util.HashMap;
import java.util.Stack;

/**
 * 문제. 사칙 연산 구현하기
 * - 수식 문자열에 맞게 사칙 연산 구현하기
 *
 * [Key Point]
 * - '중위 표기법'은 '후위 표기법'으로 변경해야한다!
 * - '후위 표기법'? 연산자를 피연사자들 뒤에 위치
 *      - 중위 표기법 : A+B+C
 *      - 후위 표기법 : ABC++
 * - 연산자 정렬 방법은 `Stack` 을 활용하자!
 *      1. 연산자를 스택에 순서대로 `push` 한다.
 *      2. 스택의 마지막 연산자의 우선 순위가 현재 연산자 보다 크거나 같은 경우, `pop` 한다.
 *          -  스택의 마지막 연산자가 큰 경우는 한번 `pop` 한다!
 *      3. 스택이 빌 때까지 나머지 연산자를 `pop` 한다.
 * - `*` or `/` 같은 경우는, `+` or `-` 보다 연산 우선 순위가 높은 경우를 고려 필요
 *
 * [Sample]
 * input : "1 + 2-3 + 5-2 * 5-3"
 * output : -8
 */
public class ArithmeticOperation {
    static HashMap<Character, Integer> op_map = new HashMap<>() {{
        put('+', 2);
        put('-', 2);
        put('*', 3);
        put('/', 3);
    }};

    public static void main(String[] args) {
        String str = "1 + 2-3 + 5-2 * 5-3";     // -8
        System.out.println("str = " + str);

        Stack<Character> op_stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.replaceAll(" ", "").toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (op_stack.isEmpty() || op_map.get(op_stack.peek()) < op_map.get(c)) {
                    op_stack.push(c);
                } else {
                    char last_op = op_stack.peek();
                    // stack 마지막 연산자가 현재 연산자보다 같거나 큰 경우
                    if (op_map.get(last_op) > op_map.get(c)) {
                        // stack 마지막 연산자가 현재 연산자보다 큰 경우
                        sb.append(op_stack.pop());
                    }
                    sb.append(op_stack.pop());
                    op_stack.push(c);
                }
            }
        }

        while (!op_stack.isEmpty()) {
            sb.append(op_stack.pop());
        }
        System.out.println("sb = " + sb);
        System.out.println("result = " + calculate(sb.toString()));
    }

    public static int calculate(String str) {
        Stack<Integer> numbers = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.push(Character.getNumericValue(c));
            } else {
                if (numbers.size() >= 2) {
                    int a = numbers.pop();
                    int b = numbers.pop();
                    int operated = operation(b, a, c);
                    System.out.println(b + " " + c + " " + a + " = " + operated);
                    numbers.push(operated);
                }
            }
        }
        return numbers.pop();
    }

    public static int operation(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }
}
