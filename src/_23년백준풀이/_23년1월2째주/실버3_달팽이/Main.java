package _23년백준풀이._23년1월2째주.실버3_달팽이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/1913
 * 풀이 날짜 : 2023-01-10
 * 풀이 참고하고 푼 문제
 * 구현 문제 많이 풀어봐야겠다.. 왜이렇게 어렵지?
 */
public class Main {

    // 하, 우, 상, 좌
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        String answer = "";

        int[][] map = new int[n][n];
        int direction = 0;
        int r = 0;
        int c = 0;
        int count = n*n;

        while (true) {
            if (count == 0) {
                break;
            }
            map[r][c] = count--;
            if (map[r][c] == target) {
                int answerRow = r+1;
                int answerCol = c+1;
                answer = answerRow + " " + answerCol;
            }

            int nr = r + dr[direction];
            int nc = c + dc[direction];

            int newDirection = directionCheck(nr, nc, direction, map);

            if (newDirection != direction) {
                nr = r + dr[newDirection];
                nc = c + dc[newDirection];
            }

            direction = newDirection;
            r = nr;
            c = nc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.deleteCharAt(sb.length()-1); // 마지막 공백 문자 제거
            sb.append("\n");
        }
        sb.append(answer);
        System.out.println(sb);
    }

    private static int directionCheck(int nr, int nc, int direction, int[][] map) {
        if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
            return (direction + 1) % 4;
        }
        if (map[nr][nc] != 0) {
            return (direction + 1) % 4;
        }
        return direction;
    }
}
