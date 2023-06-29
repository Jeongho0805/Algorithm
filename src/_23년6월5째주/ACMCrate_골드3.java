package _23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1005
 * 참고 https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=knight7024&logNo=221352688703
 * 무조건 다시보기!!!
 */
public class ACMCrate_골드3 {

    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] building = new int[n+1];
            int[] dp = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++) {
                building[i] = Integer.parseInt(st.nextToken());
                dp[i] = -1;
            }

            ArrayList<Integer>[] edges = new ArrayList[n+1];
            for (int i=0; i<=n; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                edges[start].add(end);
            }

            int w = Integer.parseInt(br.readLine());
            answer = dfs(w, edges, building, dp);
            System.out.println(answer);
        }
    }

    private static int dfs(int cur, ArrayList<Integer>[] edges, int[] building, int[] dp) {
        if (dp[cur] != -1) {
            return dp[cur];
        }
        int delayTime = 0;
        for (Integer node : edges[cur]) {
            delayTime = Math.max(delayTime, dfs(node, edges, building, dp));
        }
        dp[cur] = delayTime + building[cur];
        return dp[cur];
    }
}


