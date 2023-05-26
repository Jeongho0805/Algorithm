package _23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2294
 */
public class 동전2_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[] dp = new int[k+1];
        int MAX_VALUE = Integer.MAX_VALUE-10000;
        Arrays.fill(dp, MAX_VALUE);

        for (int coin : coins) {
            for (int i=coin; i<=k; i++) {
                if (i == coin) {
                    dp[coin] = 1;
                    continue;
                }
                dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }
        if (dp[k] == MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
