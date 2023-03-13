package _23년1월3째주.골드4_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/17144
 * 풀이 날짜 : 2023-01-19
 * 내기준 빡구현 문제,,, 복습 할 때 더 좋은 풀이 방법 있는지 확인하기
 */
public class Main {

    static ArrayList<Integer> cleanPositions;

    static int[] drUpper = {-1, 0, 1, 0};
    static int[] dcUpper = {0, 1, 0, -1};
    static int[] drLower = {1, 0, -1, 0};
    static int[] dcLower = {0, 1, 0, -1};

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int rowSize;
    static int colSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        cleanPositions = new ArrayList<>();
        map = new int[rowSize][colSize];
        for (int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleanPositions.add(i);
                }
            }
        }
        Collections.sort(cleanPositions);

        while(time-- > 0) {
            moveDust();
            clearDust();
        }

        int answer = 0;
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                if (map[i][j] != -1) {
                    answer += map[i][j];
                }
            }
        }
        System.out.println(answer);
    }

//    private static void debugMap(String s) {
//        System.out.println();
//        System.out.println(s);
//        for (int i=0; i<rowSize; i++) {
//            for (int j=0; j<colSize; j++) {
//                System.out.print(map[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    private static void clearDust() {
        cleanUpper();
        cleanLower();
    }

    private static void cleanLower() {
        int direction = 0;
        int startRow = cleanPositions.get(1);
        int startCol = 0;
        while (direction < 4) {
            int nextRow = startRow + drLower[direction];
            int nextCol = startCol + dcLower[direction];
            if (nextRow < cleanPositions.get(1) || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize) {
                direction++;
                continue;
            }
            int currentValue = map[startRow][startCol];
            int nextValue = map[nextRow][nextCol];
            if (currentValue == -1) {
                map[nextRow][nextCol] = 0;
                startRow = nextRow;
                startCol = nextCol;
                continue;
            }
            if (nextValue == -1) {
                map[startRow][startCol] = 0;
                break;
            }
            map[startRow][startCol] = map[nextRow][nextCol];
            startRow = nextRow;
            startCol = nextCol;
        }
    }

    private static void cleanUpper() {
        int direction = 0;
        int startRow = cleanPositions.get(0);
        int startCol = 0;
        while (direction < 4) {
            int nextRow = startRow + drUpper[direction];
            int nextCol = startCol + dcUpper[direction];
            if (nextRow < 0 || nextRow > cleanPositions.get(0) || nextCol < 0 || nextCol >= colSize) {
                direction++;
                continue;
            }
            int currentValue = map[startRow][startCol];
            int nextValue = map[nextRow][nextCol];
            if (currentValue == -1) {
                map[nextRow][nextCol] = 0;
                startRow = nextRow;
                startCol = nextCol;
                continue;
            }
            if (nextValue == -1) {
                map[startRow][startCol] = 0;
                break;
            }
            map[startRow][startCol] = map[nextRow][nextCol];
            startRow = nextRow;
            startCol = nextCol;
        }
    }

    private static void moveDust() {
        int[][] tempMap = new int[rowSize][colSize];
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                int dustValue = map[i][j];

                if (dustValue < 5) {
                    continue; // 5보다 작으면 확산이 일어나지 않는다.
                }

                int moveCount = 0;
                int moveValue = dustValue/5;
                for (int k=0; k<4; k++) {
                    int nextRow = i + dr[k];
                    int nextCol = j + dc[k];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize) {
                        continue;
                    }
                    if (map[nextRow][nextCol] == -1) {
                        continue;
                    }
                    tempMap[nextRow][nextCol] += moveValue;
                    moveCount++;
                }
                map[i][j] -= moveCount * moveValue;
            }
        }
        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<colSize; j++) {
                map[i][j] += tempMap[i][j];
            }
        }
    }
}
