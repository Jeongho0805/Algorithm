package _23년백준풀이._23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1167
 */
public class 트리의지름_골드2 {

    static int maxNode;
    static int maxDistance;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int destination = Integer.parseInt(st.nextToken());
                if (destination == -1) {
                    break;
                }
                edges[node].add(new Edge(destination, Integer.parseInt(st.nextToken())));
            }
        }
        boolean[] visited = new boolean[n+1];
        dfs(1, 0, visited);
        visited = new boolean[n+1];
        maxDistance = 0;
        dfs(maxNode, 0, visited);
        System.out.println(maxDistance);
    }

    private static void dfs(int node, int cost, boolean[] visited) {
        visited[node] = true;
        boolean isEnd = true;
        for (Edge edge : edges[node]) {
            if (!visited[edge.node]) {
                dfs(edge.node, cost + edge.cost, visited);
                isEnd = false;
            }
        }
        if (isEnd) {
            if (cost >= maxDistance) {
                maxNode = node;
                maxDistance = cost;
            }
        }
    }

    static class Edge {
        private int node;
        private int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int getNode() {
            return this.node;
        }

        public int getCost() {
            return this.cost;
        }
    }
}
