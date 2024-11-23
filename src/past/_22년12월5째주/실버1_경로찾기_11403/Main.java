package past._22년12월5째주.실버1_경로찾기_11403;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/11403
 * 풀이 날짜 : 2023-12-31
 * 풀이 참고하고 품
 *
 * 복습 날짜 : 2023-01-01
 * 플로이드 와샬인가? 3중 for문 알고리즘 이용하는 풀이있긴한데 dfs로 풀었다!
 *
 *
 *
 */
public class Main {

    static int[][] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            check = new boolean[n];
            for (int j=0; j<n; j++) {
                if (!check[j] && map[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void dfs(int origin, int target) {
        for (int i=0; i<map.length; i++) {
            if (!check[i] && map[target][i] == 1) {
                check[i] = true;
                map[origin][i] = 1;
                dfs(origin, i);
            }
        }
    }
}