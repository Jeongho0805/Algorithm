package _23년1월1째주.골드4_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/1197
 * 풀이 날짜 : 2023-01-02
 * 네트워크 연결 문제와 연관된 문제이다. -> 풀어보니 완전 똑같은 문제다..
 * 유니온 파인드 문제는 다 풀어보자!
 *
 * 복습 날짜 : 2023-01-08
 * sort는 객체 타입 불가능 -> 객체가 comparable를 구현하고 comparato 메서드를 구현하면 가능!
 *
 * 궁금한점 2가지
 * 1. 정점이 이미 모두 연결된 상태에서 간선관련 연산을 계속 하는 것은 비효율적인 것 아닌가? -> 찾아보니 해결 방법 있음
 * 2.우선순위 큐가 필요한 이유가 없는것같은데,, -> 실제로 ArrayList 활용해서 sort후 사용함 BUT, 프림 알고리즘 사용할 때는 우선순위 큐 필요
 *
 * 내가 사용한 안고리즘은 크루스칼! 크루스칼은 간선의 갯수가 적을때, 프림은 간선의 갯수가 많을 때 사용!
 */

// 크루스칼 풀이 -> 정점 모두 연결 되었을 시 효율성 보장 위해 다른 간선 탐색 하지 않는 방식
public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 노드 갯수
        int e = Integer.parseInt(st.nextToken()); // 간선 갯수

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        parents = new int[v+1];
        for (int i=1; i<=v; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        int answer = 0;
        for (int i=0; i<e; i++) {
            if (cnt == v-1) { // 채택한 간선 갯수가 노드 갯수 -1 과 같다면 더 이상 간선 탐색 중지
                break;
            }
            Edge current = edges.get(i);
            int x = find(current.start);
            int y = find(current.end);
            if (x == y) {
                continue;
            }
            union(x, y);
            answer += current.weight;
            cnt++;
        }
        System.out.println(answer);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX > rootY) {
            parents[rootX] = rootY; // 노드 값이 작은 쪽으로 붙여주기
        } else {
            parents[rootY] = rootX;
        }
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        parents[node] = find(parents[node]);
        return parents[node];
    }
}
class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }
}

//public class Main {
//
//    static int[] parent;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int v = Integer.parseInt(st.nextToken());
//        int e = Integer.parseInt(st.nextToken());
//
//        parent = new int[v+1];
//        for (int i=0; i<v+1; i++) {
//            parent[i] = i;
//        }
//
//        PriorityQueue<Edge> pq = new PriorityQueue<>();
//        for (int i=0; i<e; i++) {
//            st = new StringTokenizer(br.readLine());
//            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
//        }
//
//        int answer = 0;
//
//        while (!pq.isEmpty()) {
//            Edge edge = pq.poll();
//            int x = find(edge.getStart());
//            int y = find(edge.getEnd());
//
//            if (x == y) {
//                continue;
//            }
//            union(x,y);
//            answer += edge.cost;
//        }
//        System.out.println(answer);
//    }
//
//    private static void union(int x, int y) {
//        int rootX = find(x);
//        int rootY = find(y);
//        if (rootX == rootY) {
//            return;
//        }
//        if (rootX < rootY) {
//            parent[rootY] = rootX;
//            return;
//        }
//        parent[rootX] = rootY;
//    }
//
//    public static int find(int x) {
//        if (x == parent[x]) {
//            return x;
//        }
//        return parent[x] = find(parent[x]);
//    }
//}
//
//class Edge implements Comparable<Edge>{
//    int start;
//    int end;
//    int cost;
//
//    public Edge(int start, int end, int cost) {
//        this.start = start;
//        this.end = end;
//        this.cost = cost;
//    }
//
//    public int getStart() {
//        return start;
//    }
//
//    public int getEnd() {
//        return end;
//    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    @Override
//    public int compareTo(Edge o) {
//        return cost - o.cost;
//    }
//}
