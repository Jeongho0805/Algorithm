package past._23년백준풀이._23년1월3째주.실버3_비슷한단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2607
 * 풀이 날짜 : 2023-01-20
 * 풀이 참고하고 조건 추가해서 맞은 문제
 * 참고 링크 - https://m.blog.naver.com/occidere/221095055060
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String firstWord = br.readLine();
        int answer = 0;
        for (int i=0; i<n-1; i++) {
            String word = br.readLine();
            if (isSameWord(firstWord, word)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isSameWord(String firstWord, String word) {
        HashMap<String, Integer> firstWordAlphas = new HashMap<>();
        HashMap<String, Integer> otherAlphas = new HashMap<>();
        for (String alpha : firstWord.split("")) {
            firstWordAlphas.put(alpha, firstWordAlphas.getOrDefault(alpha, 0) + 1);
        }
        for (String alpha : word.split("")) {
            otherAlphas.put(alpha, otherAlphas.getOrDefault(alpha, 0) + 1);
        }
        int sum = 0;
        for (String key : firstWordAlphas.keySet()) {
            int value1 = firstWordAlphas.get(key);
            int value2 = 0;
            if (otherAlphas.get(key) != null) {
                value2 = otherAlphas.get(key);
                otherAlphas.remove(key);
            }
            sum += Math.abs(value1 - value2);
        }
        for (int value : otherAlphas.values()) {
            sum += value;
        }
        // 길이 비교가 핵심 조건
        if (sum <= 2 && Math.abs(firstWord.length() - word.length()) <= 1) {
            return true;
        }
        return false;
    }
}
