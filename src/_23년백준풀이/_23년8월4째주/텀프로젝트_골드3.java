package _23년백준풀이._23년8월4째주;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9466
 */
public class 텀프로젝트_골드3 {
    static int groupNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0 ) {
            groupNumber = 0;
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[n+1];
            boolean[] isGroup = new boolean[n+1];
            for (int i=1; i<=n; i++) {
                if (!isGroup[i]) {
                    dfs(i, visited, isGroup, nums);
                }
            }
            System.out.println(n - groupNumber);
        }
    }

    private static void dfs(int idx, boolean[] visited, boolean[] isGroup, int[] nums) {
        if (visited[idx]) {
            isGroup[idx] = true;
            groupNumber++;
        } else {
            visited[idx] = true;
        }

        if (!isGroup[nums[idx]]) {
            dfs(nums[idx], visited, isGroup, nums);
        }

        isGroup[idx] = true;
        visited[idx] = false;
    }
}
