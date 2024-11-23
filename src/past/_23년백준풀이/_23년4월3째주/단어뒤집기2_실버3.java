package past._23년백준풀이._23년4월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 링크 - https://www.acmicpc.net/problem/17413
 */
public class 단어뒤집기2_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        char[] words = s.toCharArray();
        boolean isOpen = false;
        for (char word : words) {

            if (word ==  '<') {
                if (!stack.isEmpty()) {
                    while(!stack.isEmpty()) {
                        answer.append(stack.pop());
                    }
                }
                stack.push('<');
                isOpen = true;
                continue;
            }
            if (word == ' ') {
                if (isOpen) {
                    stack.push(' ');
                    continue;
                } else {
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty()) {
                            answer.append(stack.pop());
                        }
                    }
                    answer.append(" ");
                    continue;
                }
            }

            if (word == '>') {
                Stack<Character> temp = new Stack<>();
                while(!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
                while(!temp.isEmpty()) {
                    answer.append(temp.pop());
                }
                answer.append(">");
                isOpen = false;
                continue;
            }
            stack.push(word);
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                answer.append(stack.pop());
            }
        }
        System.out.println(answer);
    }
}
