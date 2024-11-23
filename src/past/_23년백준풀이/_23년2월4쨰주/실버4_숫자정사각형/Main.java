package past._23년백준풀이._23년2월4쨰주.실버4_숫자정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] numbers = br.readLine().split("");
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int row = findRow(i, j);
                int col = findCol(i, j);
                if (map[i][j] != map[row][col]) {
                    continue;
                }
                int height = row - i + 1;
                int width = col - j + 1;
                if (height != width) {
                    continue;
                }
                max = Math.max(height * width, max);
            }
        }
        System.out.println(max);
    }

    private static int findCol(int row, int col) {
        int result = col;
        for (int i=col+1; i<map[0].length; i++) {
            if (map[row][col] == map[row][i]) {
                result = i;
            }
        }
        return result;
    }

    private static int findRow(int row, int col) {
        int result = row;
        for (int i=row+1; i<map.length; i++) {
            if (map[row][col] == map[i][col]) {
                result = i;
            }
        }
        return result;
    }
}
