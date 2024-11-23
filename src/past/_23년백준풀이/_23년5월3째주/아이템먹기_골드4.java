package past._23년백준풀이._23년5월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2411 (백트랙킹으로는 못푸는 문제)
 */
public class 아이템먹기_골드4 {

    static ArrayList<int[]> itemPositions = new ArrayList<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        while(A-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = N - (Integer.parseInt(st.nextToken()));
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 아이템 1
            itemPositions.add(new int[]{r,c});
        }
        itemPositions.add(new int[]{0, M-1});

        // itemPositionList sort
        itemPositions.sort((o1, o2) -> {
            if (o1[0] > o2[0]) {
                return -1;
            } else if (o1[0] < o2[0]) {
                return 1;
            } else {
                return o1[1] - o2[1];
            }
        });

        while(B-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = N - (Integer.parseInt(st.nextToken()));
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = -1; // 장애물 -1;
        }

        int currentRow = N-1;
        int currentCol = 0;

        // dp 배열 생성
        int[][] dp = new int[N][M];
        dp[currentRow][currentCol] = 1;
        for (int[] itemPosition : itemPositions) {
            int itemRow = itemPosition[0];
            int itemCol = itemPosition[1];
            for (int i=currentRow; i>=itemRow; i--) {
                for (int j=currentCol; j<=itemCol; j++) {
                    if (map[i][j] == -1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (i+1 > currentRow && j-1 < currentCol) {
                        continue;
                    }
                    if (i+1 > currentRow) {
                        dp[i][j] = dp[i][j-1];
                        continue;
                    }
                    if (j-1 < currentCol) {
                        dp[i][j] = dp[i+1][j];
                        continue;
                    }
                    dp[i][j] = dp[i+1][j] + dp[i][j-1];
                }
            }
            currentRow = itemRow;
            currentCol = itemCol;
        }
        System.out.println(dp[0][M-1]);
    }
}
