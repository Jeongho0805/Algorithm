package _23년8월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10942
 */
public class 팰린드롬_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            dp[i][i] = 1;
        }

        for (int i=1; i<=n-1; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for (int i=2; i<n; i++) {
            for (int j=1; j<=n-i; j++) {
                if (arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1) {
                    dp[j][j+i] = 1;
                }
            }
        }

        int query = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]).append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
