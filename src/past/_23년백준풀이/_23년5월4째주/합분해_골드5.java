package past._23년백준풀이._23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2225
 */
public class 합분해_골드5 {

    private static long MOD = 1_000_000_000L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k][n+1];

        for (int i=0; i<=n; i++) {
            dp[0][i] = 1;
        }

        for (int i=0; i<k; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<k; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }
        System.out.println(dp[k-1][n]);
    }
}
