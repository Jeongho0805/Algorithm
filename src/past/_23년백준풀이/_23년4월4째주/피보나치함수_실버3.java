package past._23년백준풀이._23년4월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/1003
 */
public class 피보나치함수_실버3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<=40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            System.out.println(dp[t][0] + " " + dp[t][1]);
        }
    }
}
