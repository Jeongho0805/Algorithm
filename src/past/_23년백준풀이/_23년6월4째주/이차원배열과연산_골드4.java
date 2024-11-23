package past._23년백준풀이._23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/17140
 */
public class 이차원배열과연산_골드4 {

    static int[][] map = new int[101][101];
    static int n = 3;
    static int m = 3;

    public static void main(String[] args) throws IOException {
        for (int[] array : map) {
            Arrays.fill(array, -1);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=1; i<=3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (count <= 100) {
//            System.out.println("n, m =(" + n +"," + m + ")");
            if (map[r][c] == k) {
                break;
            }
            if (n >= m) {
                calRow();
            } else  {
                calCol();
            }
            count++;
//            System.out.println("count = " + count);
//            for (int i=1; i<=n; i++) {
//                for (int j=1; j<=m; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        if (count == 101) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void calRow() {
        int maxCol = m;
        for (int i=1; i<=n; i++) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            List<int[]> list = new ArrayList<>();
            for (int j=1; j<=m; j++) {
                countMap.put(map[i][j], countMap.getOrDefault(map[i][j], 0) + 1);
            }
            countMap.remove(0); // 0은 제외
            for (Integer key : countMap.keySet()) {
                list.add(new int[]{key, countMap.get(key)});
            }
            int idx = 0;
            maxCol = Math.max(maxCol, countMap.size() * 2);
            list.sort((o1, o2) -> {
                if (o1[1] > o2[1]) {
                    return 1;
                }
                else if (o1[1] < o2[1]) {
                    return -1;
                }
                else {
                    return o1[0] - o2[0];
                }
            });
            for (int[] info : list) {
                if (idx + 2 <=100) {
                    map[i][++idx] = info[0];
                    map[i][++idx] = info[1];
                }
            }
            fillEmptyForEachRow(i, idx+1);
        }
        m = Math.min(maxCol, 100);
        fillEmpty();
    }

    private static void calCol() {
        int maxRow = n;
        for (int i=1; i<=m; i++) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            List<int[]> list = new ArrayList<>();
            for (int j=1; j<=n; j++) {
                countMap.put(map[j][i], countMap.getOrDefault(map[j][i], 0) + 1);
            }
            countMap.remove(0); // 0은 제외
            for (Integer key : countMap.keySet()) {
                list.add(new int[]{key, countMap.get(key)});
            }
            int idx = 0;
            maxRow = Math.max(maxRow, countMap.size() * 2);
            list.sort((o1, o2) -> {
                if (o1[1] > o2[1]) {
                    return 1;
                }
                else if (o1[1] < o2[1]) {
                    return -1;
                }
                else {
                    return o1[0] - o2[0];
                }
            });
            for (int[] info : list) {
                if (idx + 2 <=100) {
                    map[++idx][i] = info[0];
                    map[++idx][i] = info[1];
                }
            }
            fillEmptyForEachCol(i, idx+1);
        }
        n = Math.min(maxRow, 100);
        fillEmpty();
    }

    private static void fillEmptyForEachRow(int row, int start) {
        for (int i=start; i<=m; i++) {
            map[row][i] = 0;
        }
    }

    private static void fillEmptyForEachCol(int col, int start) {
        for (int i=start; i<=n; i++) {
            map[i][col] = 0;
        }
    }

    private static void fillEmpty() {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                }
            }
        }
    }
}
