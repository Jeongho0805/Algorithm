package past._23년백준풀이._23년8월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1647
 */
public class 도시분할계획_골드4 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edgeList = new ArrayList<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        edgeList.sort(Comparator.comparingInt(o -> o.weight));
        parents = new int[n+1];
        for (int i=1; i<=n; i++) {
            parents[i] = i;
        }
        int maxWeight = 0;
        int cost = 0;
        for (int i=0; i<edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.start) == find(edge.end)) { // 이미 사이클 형성되어 있을 경우 넘어가기
                continue;
            }
            union(edge.start, edge.end);
            cost += edge.weight;
            maxWeight = Math.max(maxWeight, edge.weight);
        }
        System.out.println(cost - maxWeight);
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union (int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
