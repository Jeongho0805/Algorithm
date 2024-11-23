package past._23년백준풀이._23년3월4째주;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 링크 - https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class LeetCode_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        for (String token : tokens) {
            if (operators.contains(token)) {
                int num2 = st.pop();
                int num1 = st.pop();
                int result = 0;
                if (token.equals("+")) {
                    result = num1 + num2;
                } else if (token.equals("-")) {
                    result = num1 - num2;
                } else if (token.equals("*")) {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }
                st.push(result);
                continue;
            }
            st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
}
