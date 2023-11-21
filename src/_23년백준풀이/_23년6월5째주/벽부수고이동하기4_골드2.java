package _23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16946
 * 시간초과
 */
public class 벽부수고이동하기4_골드2 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static HashMap<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        boolean[][] visit = new boolean[n][m];
        int num = 2;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] != 0 || visit[i][j]) {
                    continue;
                }
                makeCountMap(i, j, visit, num++);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] ==  1) {
                    int sum = 0;
                    HashSet<Integer> keys = new HashSet<>();
                    for (int k=0; k<4; k++) {
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];
                        if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) {
                            continue;
                        }
                        if (map[nextR][nextC] < 2) {
                            continue;
                        }
                        keys.add(map[nextR][nextC]);
                    }
                    for (Integer key : keys) {
                        sum += countMap.get(key);
                    }
                    answer.append((sum + 1) % 10);
                } else {
                    answer.append(0);
                }
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void makeCountMap(int r, int c, boolean[][] visited, int key) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int curR = position[0];
            int curC = position[1];
            map[curR][curC] = key;
            result++;
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) {
                    continue;
                }
                if (visited[nextR][nextC] || map[nextR][nextC] != 0) {
                    continue;
                }
                visited[nextR][nextC] = true;
                queue.add(new int[]{nextR, nextC});
            }
        }
        countMap.put(key, result);
    }
}
