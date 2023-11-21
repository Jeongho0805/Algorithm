package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GenerateParenthesis {

    static List<String> answer;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<String>();
        makeParenthesis("", 0, 0, n);
        return answer;
    }

    public void makeParenthesis(String temp, int left, int right, int max) {
        if (temp.length() == max*2) {
            answer.add(temp);
            return;
        }
        if (left < max) {
            makeParenthesis(temp + "(", left+1, right, max);
        }
        if (right < left) {
            makeParenthesis(temp + ")", left, right+1, max);
        }
    }
}
