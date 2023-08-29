package _23년9월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11725
 */
public class 트리의부모찾기_실버2 {

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new int[n+1];

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            /* 양방향 노드 설정 -> 어느 부분이 부모 인지 처음에 모르기 때문*/
            list[start].add(end);
            list[end].add(start);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited[parent] = true;
            ArrayList<Integer> childNodes = list[parent];
            for (int childNode : childNodes) {
                if (!visited[childNode]) {
                    answer[childNode] = parent;
                    queue.add(childNode);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=n; i++) {
            sb.append(answer[i]).append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
