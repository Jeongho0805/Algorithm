package past._23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16195
 */
public class 더하기123_실버1 {

    private static int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;

        for (int i=2; i<=1000; i++) {
            for (int j=1; j<=1000; j++) {
                if (j==1) {
                    dp[i][j] += (dp[i-1][j-1]) % MOD;
                    continue;
                }
                if (j==2) {
                    dp[i][j] += (dp[i-1][j-1] + dp[i-1][j-2]) % MOD;
                    continue;
                }
                dp[i][j] += (dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3]) % MOD;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long answer = 0;
            for (int i=1; i<=m; i++) {
                answer = (answer + dp[i][n]) % MOD;
            }
            System.out.println(answer);
        }
    }
}
