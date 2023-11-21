package _23년백준풀이._23년9월2째주;

import java.util.Stack;

public class Programmers_짝지어제거 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
