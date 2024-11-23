package past._23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14940
 */
public class 쉬운최단거리_실버1 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j, 0});
                }
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            int dist = info[2];
            map[r][c] = dist;

            for (int i=0; i<4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
                    continue;
                }
                if (map[nextR][nextC] == 0 || visited[nextR][nextC]){
                    continue;
                }
                visited[nextR][nextC] = true;
                queue.add(new int[]{nextR, nextC, dist + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    map[i][j] = -1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
