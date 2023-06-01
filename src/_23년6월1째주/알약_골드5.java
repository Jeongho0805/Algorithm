package _23년6월1째주;

import java.io.*;

/**
 * https://www.acmicpc.net/problem/4811
 */
public class 알약_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=30; i++) {
            for (int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}


