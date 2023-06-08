package _23년6월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15988
 * 수식 왜 그렇게 되는건지 이해해보기
 */
public class 더하기123_실버2 {
    public static void main(String[] args) throws IOException {
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<=1000000; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}
