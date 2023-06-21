package _23년5월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4179
 */
public class 불_골드4 {

    static int answer = Integer.MAX_VALUE;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        int[] position = new int[2];
        for (int i=0; i<n; i++) {
            String[] info = br.readLine().split("");
            for (int j=0; j<m; j++) {
                map[i][j] = info[j];
                if (map[i][j].equals("J")) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        getAnswer(position, 0);
        System.out.println(answer);
    }

    private static void getAnswer(int[] position, int time) {
        if (position[0] == 0 || position[0] == map.length-1 || position[1] == 0 || position[1] == map[0].length-1) {
            answer = Math.min(answer, time + 1);
            return;
        }

        List<int[]> fireSpreadPositions = new ArrayList<>();
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j].equals("F")) {
                    for (int k=0; k<4; k++) {
                        int nextRow = i + dr[k];
                        int nextCol = i + dc[k];
                        if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                            continue;
                        }
                        if (map[nextRow][nextCol].equals("#")) {
                            continue;
                        }
                        int[] temp = new int[2];
                        temp[0] = nextRow;
                        temp[1] = nextCol;
                        fireSpreadPositions.add(temp);
                    }
                }
            }
        }
        for (int[] fireSpreadPosition : fireSpreadPositions) {
            map[fireSpreadPosition[0]][fireSpreadPosition[1]] = "F";
        }

        for (int i=0; i<4; i++) {
            int nextRow = position[0] + dr[i];
            int nextCol = position[1] + dc[i];

            if (map[nextRow][nextCol].equals("#") || map[nextRow][nextCol].equals("F")) {
                continue;
            }
            int[] temp = {nextRow, nextCol};
            getAnswer(temp, time + 1);
        }
    }
}
