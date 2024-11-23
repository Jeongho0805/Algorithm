package past._23년백준풀이._23년7월2째주;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15684
 */
public class 사다리조작_골드3 {

    static int[][] map;
    static final int RIGHT = 1;
    static final int LEFT = -1;
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        map = new int[h+1][n+1];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = RIGHT;
            map[a][b+1] = LEFT;
        }

        int answer = -1;
        for (int i=0; i<=3; i++) {
            drawLine(i, 0);
            if (isEnd) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static void drawLine(int max, int count) {
        if (count == max) {
            if (validateMap()) {
                isEnd = true;
            }
            return;
        }

        for (int i=1; i<map.length; i++) {
            for (int j=1; j<map[0].length-1; j++) {
                if (map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = RIGHT;
                    map[i][j+1] = LEFT;
                    drawLine(max, count + 1);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }

    private static boolean validateMap() {
        for (int i=1; i<map[0].length; i++) {
            int r = 1;
            int c = i;
            for (int j=1; j<map.length; j++) {
                if (map[r][c] == RIGHT) {
                    c++;
                } else if (map[r][c] == LEFT) {
                    c--;
                }
                r++;
            }
            if (i != c) {
                return false;
            }
        }
        return true;
    }
}

//  배열 확대해서 풀이 -> 어렵다..
//    static int[][] map;
//    static boolean isArrived = false;
//    static final int MOVE_POSSIBLE = 1;
//    static final int MOVE_IMPOSSIBLE = 0;
//    static final int CROSS_YES = -1;
//    static final int CROSS_NO = -2;
//    static int[] dr = {0, 0, 1}; // 좌, 우, 하
//    static int[] dc = {-1, 1, 0};
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int h = Integer.parseInt(st.nextToken());
//
//        map = new int[h + 2][n * 2 + 1];
//        for (int i=1; i<=h+1; i++) { // 세로선 모두 이동 가능 처리
//            for (int j=2; j<=map[0].length; j+=2) {
//                map[i][j] = MOVE_POSSIBLE;
//            }
//        }
//
//        for (int i=0; i<m; i++) { // 가로선 그어주기
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            map[a][b * 2 + 1] = MOVE_POSSIBLE;
//        }
//
//        // debug
//        for (int i=0; i<map.length; i++) {
//            for (int j=0; j<map[0].length; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        int answer = -1;
//        if (isArrivedProperly()) {
//            answer = 0;
//            isArrived = true;
//        }
//        else {
//            for (int i = 1; i <= 3; i++) {
//                drawLine(i, 0);
//                if (isArrived) {
//                    answer = i;
//                    break;
//                }
//            }
//        }
//        System.out.println(answer);
//    }
//
//    private static void drawLine(int maxCount, int curCount) {
//        if (curCount == maxCount) {
//            if (isArrivedProperly()) {
//                isArrived = true;
//            }
//            // debug
//            System.out.println();
//            for (int i=0; i<map.length; i++) {
//                for (int j=0; j<map[0].length; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            return;
//        }
//
//        for (int i=1; i<map.length-1; i++) {
//            for (int j=2; j<map[0].length; j+=2) {
//                int min = j-2;
//                int max = j+2;
//                if (min < 2 ) {
//                    if (map[i][j+1] == MOVE_IMPOSSIBLE) {
//                        map[i][j+1] = MOVE_POSSIBLE;
//                        drawLine(maxCount, curCount + 1);
//                        map[i][j+1] = MOVE_IMPOSSIBLE;
//                        continue;
//                    }
//                }
//                if (max > map[0].length-1) {
//                    if (map[i][j-1] == MOVE_IMPOSSIBLE) {
//                        map[i][j-1] = MOVE_POSSIBLE;
//                        drawLine(maxCount, curCount + 1);
//                        map[i][j-1] = MOVE_IMPOSSIBLE;
//                        continue;
//                    }
//
//                }
//                if (map[i][j] == MOVE_IMPOSSIBLE) {
//                    if (map[i][j+1] == MOVE_IMPOSSIBLE) {
//                        map[i][j+1] = MOVE_POSSIBLE;
//                        drawLine(maxCount, curCount + 1);
//                        map[i][j+1] = MOVE_IMPOSSIBLE;
//                    }
//
//                    if (map[i][j-1] == MOVE_IMPOSSIBLE) {
//                        map[i][j-1] = MOVE_POSSIBLE;
//                        drawLine(maxCount, curCount + 1);
//                        map[i][j-1] = MOVE_IMPOSSIBLE;
//                    }
//                }
//            }
//        }
//    }
//
//    private static boolean isArrivedProperly() {
//        Queue<int[]> queue = new LinkedList<>();
//        for (int i=2; i<map[0].length; i+=2) {
//            queue.add(new int[]{1, i, i, CROSS_NO});
//        }
//
//        while (!queue.isEmpty()) {
//            int[] info = queue.poll();
//            int curR = info[0];
//            int curC = info[1];
//            int startC = info[2];
//            int isCross = info[3];
//
//            System.out.println(curR + " " + curC);
//
//            if (curR == map.length-1) {
//                System.out.println("curC = " + curC + " startC = " + startC);
//                if (curC != startC) {
//                    return false;
//                }
//                continue;
//            }
//
//
//            for (int i=0; i<3; i++) {
//                int nextR = curR + dr[i];
//                int nextC = curC + dc[i];
//                if (nextR < 1 || nextR >= map.length || nextC + dc[i] < 2 || nextC + dc[i] >= map[0].length) {
//                    continue;
//                }
//                if (map[nextR][nextC] == MOVE_IMPOSSIBLE) {
//                    continue;
//                }
//                if (map[nextR][nextC] == MOVE_POSSIBLE && isCross == CROSS_YES) { // 세로줄 한번 이용한 경우
//                    if (i==0 || i==1) {
//                        continue;
//                    }
//                }
//
//                if (i == 0 || i == 1) {
//                    nextC += dc[i];
//                    isCross = CROSS_YES;
//                } else {
//                    isCross = CROSS_NO;
//                }
//                queue.add(new int[]{nextR, nextC, startC, isCross});
//            }
//        }
//        return true;
//    }
//}
