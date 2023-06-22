package _23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1890
 */
public class 점프_실버1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];
        dp[1][1] = 1;

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                if (i==n && j==n) {
                    break;
                }
                int step = Integer.parseInt(st.nextToken());
                if (dp[i][j] != 0) {
                    int nextR = i + step;
                    int nextC = j + step;
                    if (nextR <= n) {
                        dp[nextR][j] += dp[i][j];
                    }
                    if (nextC <= n) {
                        dp[i][nextC] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
