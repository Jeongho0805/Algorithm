package _23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1753
 */
public class 최단경로_골드4 {

    static final int INF = Integer.MAX_VALUE;
    static int[] costArray;
    static boolean[] visited;
    static ArrayList<Graph>[] edges;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        edges = new ArrayList[v + 1];
        for (int i=0; i<=v; i++) {
            edges[i] = new ArrayList<>();
        }


        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[node].add(new Graph(destination, cost));
        }

        visited = new boolean[v+1];
        costArray = new int[v+1];
        Arrays.fill(costArray, INF);

        dijkstra(k);

        StringBuilder answer = new StringBuilder();
        for (int i=1; i<=v; i++) {
            if (costArray[i] == INF) {
                answer.append("INF").append("\n");
            } else {
                answer.append(costArray[i]).append("\n");
            }
        }
        System.out.println(answer);
    }

    private static void dijkstra(int k) {
        PriorityQueue<Graph> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        queue.add(new Graph(k, 0));
        costArray[k] = 0;

        while(!queue.isEmpty()) {
            Graph cur = queue.poll();

            for (Graph graph : edges[cur.node]) {
                if (!visited[graph.node]) {
                    if (cur.cost + graph.cost < costArray[graph.node]) {
                        costArray[graph.node] = cur.cost + graph.cost;
                        visited[cur.node] = true;
                        queue.add(new Graph(graph.node, costArray[graph.node]));
                    }
                }
            }
        }
    }

    static class Graph {

        private int node;

        private int cost;

        public Graph(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
