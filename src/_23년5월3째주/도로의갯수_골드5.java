package _23년5월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1577
 */
public class 도로의갯수_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];

        HashSet<String> brokenRoad = new HashSet<>();
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(Math.min(y1, y2)).append(" ");
            sb.append(Math.min(x1, x2)).append(" ");
            sb.append(Math.max(y1, y2)).append(" ");
            sb.append(Math.max(x2, x1));
            brokenRoad.add(sb.toString());

        }

        long[][] dp = new long[n+1][m+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                if (i-1 >= 0) {
                    String road = i-1 + " " + j + " " + i + " " + j;
                    if (!brokenRoad.contains(road)) {
                        dp[i][j] += dp[i-1][j];
                    }
                }

                if (j-1 >= 0) {
                    String road = i + " " + (j-1) + " " + i + " " + j;
                    if (!brokenRoad.contains(road)) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
