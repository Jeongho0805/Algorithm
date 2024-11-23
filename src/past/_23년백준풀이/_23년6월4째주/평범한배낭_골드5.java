package past._23년백준풀이._23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12865
 * 무게 역순 탐색 안하면, 자기꺼랑 겹쳐서 카운트 중복된다.
 */
public class 평범한배낭_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] bags = new int[n][2];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k+1];
        for (int i=0; i<n; i++) {
            for (int j=k; j>=0; j--) {
                if (bags[i][0] <= j) {
                    dp[j] = Math.max(dp[j], bags[i][1] + dp[j - bags[i][0]]);
                }
            }
        }
        System.out.println(dp[k]);
    }
}
