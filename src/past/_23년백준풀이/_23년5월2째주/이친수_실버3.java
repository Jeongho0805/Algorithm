package past._23년백준풀이._23년5월2째주;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2193
 */
public class 이친수_실버3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
