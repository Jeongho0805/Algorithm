package _23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2252
 */
public class 줄세우기_골드3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degrees = new int[n + 1];
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            edges[start].add(end);
            degrees[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            answer.add(node);
            for (int nextNode : edges[node]) {
                degrees[nextNode]--;
                if (degrees[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer value : answer) {
            sb.append(value).append(" ");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
