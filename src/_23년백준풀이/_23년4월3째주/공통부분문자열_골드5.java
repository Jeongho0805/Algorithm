package _23년백준풀이._23년4월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/5582
 */
public class 공통부분문자열_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wordsA = br.readLine().split("");
        String[] wordsB = br.readLine().split("");

        int[][] map = new int[wordsA.length][wordsB.length];

        for (int i=0; i<wordsA.length; i++) {
            for (int j=0; j<wordsB.length; j++) {
                if (i == 0) {
                    if (wordsA[i].equals(wordsB[j])) {
                        map[i][j]++;
                        continue;
                    }
                }
                if (j == 0) {
                    if (wordsA[i].equals(wordsB[j])) {
                        map[i][j]++;
                        continue;
                    }
                }
                if (wordsA[i].equals(wordsB[j])) {
                    map[i][j] = map[i-1][j-1] + 1;
                }
            }
        }
        int answer = 0;
        for (int i=0; i< wordsA.length; i++) {
            for (int j=0; j<wordsB.length; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
        System.out.println(answer);
    }
}
