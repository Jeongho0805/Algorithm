package _23년4월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/1913
 */
public class 달팽이_실버3 {

    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int num = n*n;
        int[][] map = new int[n][n];
        int row = 0;
        int col = 0;
        int direction = 0;
        map[row][col] = num--;
        while(num > 0) {
            int nextRow = row + dr[direction];
            int nextCol = col + dc[direction];

            if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                direction = (direction + 1) % 4;
                continue;
            }
            if (map[nextRow][nextCol] != 0) {
                direction = (direction + 1) % 4;
                continue;
            }
            map[nextRow][nextCol] = num--;
            row = nextRow;
            col = nextCol;
        }

        StringBuilder sb = new StringBuilder();
        int targetRow = 0;
        int targetCol = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == target) {
                    targetRow = i+1;
                    targetCol = j+1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(targetRow + " " + targetCol);
        System.out.println(sb);
    }
}
