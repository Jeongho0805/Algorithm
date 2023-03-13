package _23년1월2째주.실버1_오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2615
 * 풀이 날짜 : 2023-01-10
 * 구현 문제 많이 풀기!
 * 풀었는데 틀린 문제 -> 반례가 기가막히다,,, 6번쨰 뿐만 아니라 첫번째 이전의 알도 고려해줘야 한다...
 */
public class Main {

    static int[][] map = new int[19][19];
    // 상, 하, 좌, 우, 대각 포함
    static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dc = {0, 1, 0, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        root : for (int i=0; i<19; i++) {
            for (int j=0; j<19; j++) {
                if (map[i][j] != 0) {
                    check(i, j, sb);
                    if (sb.length() != 0) {
                        break root;
                    }
                }
            }
        }
        if (sb.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

    private static void check(final int row, final int col, final StringBuilder sb) {

        root : for (int i=0; i<8; i++) {
            int curRow = row;
            int curCol = col;

            for (int j=0; j<4; j++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map[0].length) {
                    continue root;
                }
                if (map[nextRow][nextCol] != map[curRow][curCol]) {
                    continue root;
                }
                curRow = nextRow;
                curCol = nextCol;
            }

            int beforeRow = row - dr[i];
            int beforeCol = col - dc[i];
            if (beforeRow >= 0 && beforeRow < map.length && beforeCol >= 0 && beforeCol < map[0].length) {
                if (map[beforeRow][beforeCol] == map[row][col]) {
                    continue root;
                }
            }

            int sixthRow = curRow + dr[i];
            int sixthCol = curCol + dc[i];
            if (sixthRow >= 0 && sixthRow < map.length && sixthCol >= 0 && sixthCol < map[0].length) {
                if (map[sixthRow][sixthCol] == map[curRow][curCol]) {
                    continue root;
                }
            }

            int leftCol = Math.min(col, curCol);
            int leftRow = 0;
            if (leftCol == col) {
                leftRow = row;
            } else {
                leftRow = curRow;
            }
            sb.append(map[curRow][curCol] + "\n");
            sb.append((leftRow+1) + " " + (leftCol+1));
            break;
        }
    }
}
