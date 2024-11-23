package past._23년백준풀이._23년1월1째주.골드5_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/9251
 * 풀이 날짜 : 2023-01-04
 * 최장 공통 수열 문제 -> 풀이 참고해서 풀었음 무조건 복습!
 *
 * 복습 날짜 : 2023-01-08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word1 = br.readLine().split("");
        String[] word2 = br.readLine().split("");

        int[][] lcs = new int[word1.length + 1][word2.length + 1];
        for (int i=1; i<=word1.length; i++) {
            for (int j=1; j<=word2.length; j++) {
                if (word1[i-1].equals(word2[j-1])) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[word1.length][word2.length]);
    }
}