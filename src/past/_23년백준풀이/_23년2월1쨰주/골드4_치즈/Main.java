package past._23년백준풀이._23년2월1쨰주.골드4_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2636
 * 풀이 날짜 : 2023-01-30
 */
public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];

        for (int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int cnt = 0;
        while (!isMeltingAll(map)) {
            findAir(map);
            meltCheese(map);
            time++;

            if (isMeltingAll(map)) {
                cnt = findPrevCheeseCount(map);
            }
        }
        System.out.println(time);
        System.out.println(cnt);
    }

    private static int findPrevCheeseCount(int[][] map) {
        int result = 0;
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j] == 3) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void meltCheese(int[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j] != 2) {
                    continue;
                }
                for (int k=0; k<4; k++) {
                    int nextRow = i + dr[k];
                    int nextCol = j + dc[k];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map[0].length) {
                        continue;
                    }
                    if (map[nextRow][nextCol] == 2 || map[nextRow][nextCol] == 3) {
                        continue;
                    }
                    map[nextRow][nextCol] = 3;
                }
            }
        }
    }

    private static void findAir(int[][] map) {
        int startRow = 0;
        int startCol = 0;
        int[] position = new int[]{startRow, startCol};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(position);
        boolean[][] visited = new boolean[map.length][map[0].length];

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curRow = curPos[0];
            int curCol = curPos[1];

            for (int i=0; i<4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                    continue;
                }
                if (map[nextRow][nextCol] == 1 || visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;
                map[nextRow][nextCol] = 2;
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }

    private static boolean isMeltingAll(int[][] map) {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
