package _23년6월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21923
 */
public class 곡예비행_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] upDp = new int[n][m];
        int[][] downDp = new int[n][m];

        for (int i=map.length-1; i>=0; i--) {
            for (int j=0; j<m; j++) {
                if (i == map.length-1 && j == 0) {
                    upDp[i][j] = map[i][j];
                    continue;
                }
                if (i+1 < map.length && j-1 >= 0) {
                    upDp[i][j] = Math.max(upDp[i+1][j], upDp[i][j-1]) + map[i][j];
                    continue;
                }
                if (i+1 < map.length) {
                    upDp[i][j] = upDp[i+1][j] + map[i][j];
                    continue;
                }
                upDp[i][j] = upDp[i][j-1] + map[i][j];
            }
        }

        for (int i = map.length-1; i>=0; i--) {
            for (int j=map[0].length-1; j>=0; j--) {
                if (i == map.length-1 && j == map[0].length-1) {
                    downDp[i][j] = map[i][j];
                    continue;
                }
                if (i+1 < map.length && j+1 < map[0].length) {
                    downDp[i][j] = Math.max(downDp[i+1][j], downDp[i][j+1]) + map[i][j];
                    continue;
                }
                if (i+1 < map.length) {
                    downDp[i][j] = downDp[i+1][j] + map[i][j];
                    continue;
                }
                downDp[i][j] = downDp[i][j+1] + map[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                answer = Math.max(answer, upDp[i][j] + downDp[i][j]);
            }
        }
        System.out.println(answer);
    }
}
