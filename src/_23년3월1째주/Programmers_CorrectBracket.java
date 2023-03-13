package _23년3월1째주;

import java.util.Stack;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Programmers_CorrectBracket {

    public boolean solution(String s) {

        char[] barckets = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char bracket : barckets) {
            if (bracket == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

