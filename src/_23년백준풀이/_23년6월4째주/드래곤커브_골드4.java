package _23년백준풀이._23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15685
 */
public class 드래곤커브_골드4 {

    static boolean[][] map = new boolean[101][101];
    // 시계 정 방향
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            makeDragon(x, y, d, g);
        }
        int answer = countSquare();
        System.out.println(answer);
    }

    private static int countSquare() {
        int count = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (map[i][j] && map[i+1][j] && map[i+1][j+1] && map[i][j+1]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void makeDragon(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);
        while (g-- > 0) {
            for (int i=directions.size()-1; i>=0; i--) {
                int direction = (directions.get(i) + 1) % 4;
                directions.add(direction);
            }
        }
        map[y][x] = true;
        for (Integer direction : directions) {
            int ny = y + dr[direction];
            int nx = x + dc[direction];
            map[ny][nx] = true;
            x = nx;
            y = ny;
        }
    }
}
