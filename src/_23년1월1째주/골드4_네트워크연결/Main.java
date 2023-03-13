package _23년1월1째주.골드4_네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/1922
 * 풀이 날짜 : 2023-01-02
 * 풀이 참고해서 푼 문제!
 * 최소신장트리 문제 -> 프림이나 크루스칼 알고리즘을 통해 풀 수 있다고 한다.
 * comparable 객체에 심어주는 방식 학습할 필요가 있어보인다.
 * 꼭! 다시 복습해볼 문제이다.
 *
 * 복습 날짜 : 2023-01-08
 */
public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for (int i=0; i<n+1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            int x = find(edge.start);
            int y = find(edge.end);

            if (x == y) {
                continue;
            }
            union(x,y);
            answer += edge.cost;
        }
        System.out.println(answer);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }

    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public int getCost() {
        return cost;
    }
    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}
