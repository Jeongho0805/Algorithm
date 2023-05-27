package _23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1238
 * 시간초과 -> 좋은 문제 다익스트라
 *
 */
public class 파티_골드3 {

    static class Node {
        int end;
        int distance;

        public Node(int end, int cost) {
            this.end = end;
            this.distance = cost;
        }
    }
    static ArrayList<Node>[] nodeList;
    static ArrayList<Node>[] reverseList;
    static int[] distance;
    static int[] reverseDistance;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int party = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[n+1];
        reverseList = new ArrayList[n+1];

        for (int i=1; i<=n; i++) {
            nodeList[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        distance = new int[n+1];
        reverseDistance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(reverseDistance, Integer.MAX_VALUE);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList[start].add(new Node(end, cost));
            reverseList[end].add(new Node(start, cost));
        }

        dijkstra(nodeList, distance, party);
        dijkstra(reverseList, reverseDistance, party);

        int answer = 0;
        for (int i=1; i<=n; i++) {
            answer = Math.max(answer, distance[i] + reverseDistance[i]);
        }
        System.out.println(answer);
    }

    private static void dijkstra(ArrayList<Node>[] nodeList, int[] distance, int party) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance - o2.distance;
            }
        });
        boolean[] visited = new boolean[n+1];
        pq.add(new Node(party, 0));

        distance[party] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.end;

            if (visited[idx]) {
                continue;
            }
            visited[idx] = true;
            for (Node temp : nodeList[idx]) {
                if (distance[temp.end] > temp.distance + distance[idx]) {
                    distance[temp.end] = temp.distance + distance[idx];
                    pq.add(new Node(temp.end, distance[temp.end]));
                }
            }

        }
    }
}

