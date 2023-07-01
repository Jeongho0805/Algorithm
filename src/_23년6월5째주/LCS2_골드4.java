package _23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9252
 * 객체로 생성해서 순방향 추적화면 메모리 초과
 */
public class LCS2_골드4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word2 = br.readLine().split("");
        String[] word1 = br.readLine().split("");

        int[][] map = new int[word1.length+1][word2.length+1];

        for (int i=1; i<=word1.length; i++) {
            for (int j=1; j<=word2.length; j++) {
                if (word1[i-1].equals(word2[j-1])) {
                    map[i][j] = map[i-1][j-1] + 1;
                }
                else {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int row = word1.length;
        int col = word2.length;
        while (row >= 1 && col >=1) {
            if (map[row][col] == map[row-1][col]) {
                row--;
            }
            else if (map[row][col] == map[row][col-1]) {
                col--;
            }
            else {
                sb.append(word1[row-1]);
                row--;
                col--;
            }
        }
        int count = map[word1.length][word2.length];
        System.out.println(count);
        if (count != 0) {
            System.out.println(sb.reverse());
        }
    }
}
