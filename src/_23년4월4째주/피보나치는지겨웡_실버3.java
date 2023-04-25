package _23년4월4째주;

import java.util.Scanner;

/**
 * 링크 - https://www.acmicpc.net/problem/17175
 */
public class 피보나치는지겨웡_실버3 {

    public static long count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println(1);
        } else {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i=2; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2] + 1) % 1000000007 ;
            }
            System.out.println(dp[n]);
        }
    }
}
