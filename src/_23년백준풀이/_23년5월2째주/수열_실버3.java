package _23년백준풀이._23년5월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2559
 */
public class 수열_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];


        for (int i=1; i<=k; i++) {
            dp[k] += arr[i];
        }

        for (int i=0; i<k; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i=k+1; i<=n; i++) {
            dp[i] = dp[i-1] - arr[i-k] + arr[i];
        }

        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}
