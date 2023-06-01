package _23년6월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12896
 */
public class 스크루지민호_골드2 {

    static int answer = 0;
    static int node;
    static List<Integer>[] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];

        for (int i=0; i<=n; i++) {
            nodes[i] = new ArrayList<>();
        }

        n--;
        while (n-- >0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[start].add(end);
            nodes[end].add(start);
        }

        boolean[] visited = new boolean[nodes.length];
        visited[1] = true;
        dfs (1, visited, 0);

        visited = new boolean[nodes.length];
        visited[node] = true;
        dfs (node, visited, 0);

        System.out.println((answer + 1) /2);
    }

    private static void dfs(int num, boolean[] visited, int distance) {
        if (answer < distance) {
            answer = distance;
            node = num;
        }
        for (Integer number : nodes[num]) {
            if (!visited[number]) {
                visited[number] = true;
                dfs(number, visited, distance +1);
                visited[number] = false;
            }
        }
    }
}
