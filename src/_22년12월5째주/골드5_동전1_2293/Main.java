package _22년12월5째주.골드5_동전1_2293;

import java.io.*;
import java.util.*;
/**
 * 링크 - https://www.acmicpc.net/problem/2293
 * 2022-12-30 풀이 -> dp문제 풀이 옮긴것 꼭 다시 풀기
 *
 * 복습 날짜 : 2023-01-01
 * 감이 안잡히거든 공책에 규칙대로 다 적어봐라!!
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];

        /* 핵심 부분 */
        dp[0] = 1;

        for (int i=0; i<n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j=1; j<=k; j++) {
                if (j >= coin) {
                    dp[j] += dp[j-coin];
                }
            }
            Arrays.stream(dp).forEach(value -> System.out.print(value+" "));
            System.out.println();
        }
        System.out.println();
        System.out.println(dp[k]);


    }
}