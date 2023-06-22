package _23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7579
 */
public class 앱_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] memory = new int[n+1];
        int[] cost = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001];

        for (int i=1; i<=n; i++) {
            for (int j=10000; j>= cost[i]; j--) {
                dp[j] = Math.max(dp[j-cost[i]] + memory[i], dp[j]);
            }
        }

        for (int i=0 ;i<10001; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
