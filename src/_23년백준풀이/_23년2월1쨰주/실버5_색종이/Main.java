package _23년백준풀이._23년2월1쨰주.실버5_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2563
 * 풀이 날짜 : 2023-01-30
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = n;
        int[][] map = new int[101][101];
        int minusCnt = 0;
        while (cnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int minRow = Integer.parseInt(st.nextToken());
            int minCol = Integer.parseInt(st.nextToken());

            for (int i=minRow; i<minRow+10; i++) {
                for (int j=minCol; j<minCol+10; j++) {
                    int value = map[i][j];
                    if (value == 1) {
                        minusCnt++;
                        continue;
                    }
                    map[i][j] = 1;
                }
            }
        }
        System.out.println(100 * n - minusCnt);
    }
}
