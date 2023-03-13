package _23년1월2째주.실버1_배열돌리기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/16926
 * 풀이 날짜 : 2023-01-13
 * 풀이 참고해서 푼 문제
 */
public class Main {

    // 우,하,좌,상
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
    static int groupCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int rotate = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        groupCount = Math.min(n, m) / 2;
        while (rotate-- > 0) {
            rotateMap();
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotateMap() {
        for (int i=0; i<groupCount; i++) {
            int edge = 0;
            int curRow = i;
            int curCol = i;
            int firstValue = map[curRow][curCol];
            while (edge < 4) {
                int nextRow = curRow + dr[edge];
                int nextCol = curCol + dc[edge];

                if (nextCol < i || nextRow < i || nextCol >= map[0].length - i || nextRow >= map.length - i) {
                    edge++;
                    continue;
                }
                map[curRow][curCol] = map[nextRow][nextCol];
                curRow = nextRow;
                curCol = nextCol;
            }
            map[i+1][i] = firstValue;
        }
    }
}
