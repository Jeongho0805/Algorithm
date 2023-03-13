package _23년2월4쨰주.Programmers_전화번호목록;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};
        Solution s = new Solution();
        boolean result = s.solution(phone_book);
        System.out.println(result);
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));
        // 933  9 93
        for (String number : phone_book) {
            for (int i=1; i<number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}

/**
 * 1,000,000 * 1,000,000  = 1,000,000,000,000
 *
 * 1 2 34 123   3 34
 * set - 1 2
 */

class Solution2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (Comparator.comparingInt(String::length)));
        HashSet<String> set = new HashSet<>();
        boolean answer = true;
        root : for (String number : phone_book) {
            if (set.size() > 0) {
                for (String word : set) {
                    if (number.substring(0, word.length()).equals(word)) {
                        answer = false;
                        break root;
                    }
                }
            }
            set.add(number);
        }
        return answer;
    }
}