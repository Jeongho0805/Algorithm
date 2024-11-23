package past._23년백준풀이._23년3월3째주.실버2_색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 링크 - https://www.acmicpc.net/problem/2630
 */
public class Main {

    static int[][] map;
    static int[] answer = new int[2];

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
        countPaper(0, 0, n-1, n-1);
        System.out.println(answer[0] + "\n" + answer[1]);
    }

    private static void countPaper(int startRow, int startCol, int endRow, int endCol) {

        int value = map[startRow][startCol];
        boolean isEnd = true;
        root: for (int i=startRow; i<=endRow; i++) {
            for (int j=startCol; j<=endCol; j++) {
                if (map[i][j] != value) {
                    isEnd = false;
                    break root;
                }
            }
        }

        if (isEnd == true) {
            answer[value]++;
            return;
        }

        int midRow = startRow + ((endRow - startRow) / 2);
        int midCol = startCol + ((endCol - startCol) / 2);
        countPaper(startRow, startCol, midRow, midCol);
        countPaper(startRow, midCol + 1, midRow, endCol);
        countPaper(midRow + 1, startCol, endRow, midCol);
        countPaper(midRow + 1 , midCol + 1, endRow, endCol);
    }
}
