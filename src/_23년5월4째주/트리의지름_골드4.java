package _23년5월4째주;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1967
 */
public class 트리의지름_골드4 {
    static ArrayList<Node>[] nodes;
    static boolean visited[];
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            nodes[i] = new ArrayList<Node>();
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[parent].add(new Node(child, weight));
            nodes[child].add(new Node(parent, weight));
        }

        for (int i=1; i<=n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int idx, int weight) {
        for (Node node : nodes[idx]) {
            if (!visited[node.idx]) {
                visited[node.idx] = true;
                dfs (node.idx, weight + node.weight);
            }
        }
        answer = Math.max(answer, weight);
    }
}

class Node {
    int idx;
    int weight;

    public Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}