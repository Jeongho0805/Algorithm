package _23년백준풀이._23년1월3째주.실버4_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/status?user_id=pjhpjh0805&problem_id=10157&from_mine=1
 * 풀이 날짜 : 2023-01-21
 * 구현은 실버인데도 왜이렇게 어렵지... 틀린 문제!
 * 틀린 이유를 도무지 모르겠네,,, 넘어가기
 */
public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int rowSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        if (rowSize * colSize < k) { // k인 관객에게 좌석 배정을 할 수 없는 경우
            System.out.println(0);
        }
        else if (k == 1) {
            int[] position = getPosition(rowSize-1, 0);
            System.out.println(position[0] + " " + position[1]);
        }
        else {
            int[][] map = new int[rowSize][colSize];

            int direction = 0;
            int currentRow = rowSize - 1;
            int currentCol = 0;
            int order = 1;
            map[currentRow][currentCol] = order;

            while (true) {
                int nextRow = currentRow + dr[direction];
                int nextCol = currentCol + dc[direction];

                if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize) {
                    direction = (direction + 1) % 4;
                    continue;
                }
                if (map[nextRow][nextCol] != 0) {
                    direction = (direction + 1) % 4;
                    continue;
                }
                order++;
                map[nextRow][nextCol] = order;
                if (order == k) {
                    int[] position = getPosition(nextRow, nextCol);
                    System.out.println(position[0] + " " + position[1]);
                    break;
                }
                currentRow = nextRow;
                currentCol = nextCol;
            }
        }
    }

    private static int[] getPosition(int row, int col) {
        int x = col + 1;
        int y = rowSize - row;
        return new int[]{x, y};
    }
}
