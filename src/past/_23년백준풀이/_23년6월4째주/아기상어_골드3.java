package past._23년백준풀이._23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16236
 */
public class 아기상어_골드3 {

    static int n;
    static Shark shark;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2);
                }
            }
        }

        int second = 0;
        while (true) {
            int[] feedInfo = scanMap();
            if (feedInfo.length == 0) { // 먹이가 없으면 엄마 상어에게 도움
                break;
            }
            second += feedInfo[2];
            shark.setPosition(feedInfo[0], feedInfo[1]);
            shark.eat();
            map[feedInfo[0]][feedInfo[1]] = 0;
        }
        System.out.println(second);
    }

    private static int[] scanMap() {
        List<int[]> feedList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] != 0 && map[i][j] != 9 && map[i][j] < shark.size) {
                    int distance = CalDistance(i, j, shark.getR(), shark.getC());
                    if (distance != -1) {
                        feedList.add(new int[]{i, j, distance});
                    }
                }
            }
        }
        if (feedList.size() == 0) {
            return new int[]{};
        }
        feedList.sort((o1, o2) -> {
            if (o1[2] < o2[2]) {
                return -1;
            }
            else if (o1[2] > o2[2]) {
                return 1;
            }
            else {
                if (o1[0] > o2[0]) {
                    return 1;
                }
                else if (o1[0] < o2[0]) {
                    return -1;
                }
                else {
                    return o1[1] - o2[1];
                }
            }
        });
        return feedList.get(0);
    }

    private static int CalDistance(int r, int c, int sR, int sC) {
        boolean[][] isVisited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sR, sC, 0});
        isVisited[sR][sC] = true;

        while(!queue.isEmpty()) {
            int[] position = queue.poll();

            if (position[0] == r && position[1] == c) {
                return position[2];
            }
            for (int i=0; i<4; i++) {
                int nr = position[0] + dr[i];
                int nc = position[1] + dc[i];
                if (nr >= n || nr < 0 || nc >= n || nc < 0) {
                    continue;
                }
                if (isVisited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] > shark.size && map[nr][nc] != 9) {
                    continue;
                }
                isVisited[nr][nc] = true;
                queue.add(new int[]{nr, nc, position[2] + 1});
            }
        }
        return -1;
    }

    static class Shark {
        private int r;
        private int c;
        private int size;
        private int count = 0;

        public Shark(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getSize() {
            return size;
        }

        public void setPosition(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void eat() {
            count++;
            if (count == size) {
                size++;
                count = 0;
            }
        }
    }
}


