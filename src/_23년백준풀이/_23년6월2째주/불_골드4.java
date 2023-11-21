package _23년백준풀이._23년6월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/5427
 */
public class 불_골드4 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] map = new char[m][n];
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                String input = br.readLine();
                map[i] = input.toCharArray();
            }
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        queue.add(new int[]{-1, i, j});
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '@') {
                        visited[i][j] = true;
                        queue.add(new int[]{0, i, j});
                    }
                }
            }


            boolean isExit = false;
            int answer = 0;
            root: while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int r = pos[1];
                int c = pos[2];
                if (pos[0] == -1) { // 불일 경우에
                    for (int i = 0; i < 4; i++) {
                        int nRow = r + dr[i];
                        int nCol = c + dc[i];
                        if (nRow < 0 || nCol < 0 || nRow >= map.length || nCol >= map[0].length) {
                            continue;
                        }
                        if (map[nRow][nCol] == '#' || map[nRow][nCol] == '*') {
                            continue;
                        }
                        map[nRow][nCol] = '*';
                        queue.add(new int[]{-1, nRow, nCol});
                    }
                } else { // 사람일 경우에
                    for (int i = 0; i < 4; i++) {
                        int nRow = r + dr[i];
                        int nCol = c + dc[i];
                        if (nRow < 0 || nCol < 0 || nRow >= map.length || nCol >= map[0].length) {
                            isExit = true;
                            answer = pos[0] + 1;
                            break root;
                        }
                        if (map[nRow][nCol] == '#' || map[nRow][nCol] == '*' ) {
                            continue;
                        }
                        if (visited[nRow][nCol]) {
                            continue;
                        }
                        visited[nRow][nCol] = true;
                        queue.add(new int[]{pos[0] + 1, nRow, nCol});
                    }
                }
            }
            if (isExit) {
                System.out.println(answer);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
