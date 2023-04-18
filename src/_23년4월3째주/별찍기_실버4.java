package _23년4월3째주;

import java.util.Scanner;

/**
 * 링크 - https://www.acmicpc.net/problem/10994
 */
public class 별찍기_실버4 {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int size = (number - 1) * 4 + 1 ;
        char[][] map = new char[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                map[i][j] = ' ';
            }
        }

        int startRow = 0;
        int startCol = 0;
        int tempRow = 0;
        int tempCol = 0;
        while(number > 0) {
            int direction = 0;
            if (number == 1) {
                map[startRow][startCol] = '*';
                break;
            }
            map[startRow][startCol] = '*';
            while (true) {
                int nextRow = tempRow + dr[direction];
                int nextCol = tempCol + dc[direction];

                if (nextRow == startRow && nextCol == startCol) {
                    startRow += 2;
                    startCol += 2;
                    tempRow = startRow;
                    tempCol = startCol;
                    break;
                }

                if (nextRow < startRow || nextRow >= startRow + (number-1) * 4 + 1 || nextCol < startCol || nextCol >= startCol + (number-1) * 4 + 1 ) {
                    direction++;
                    continue;
                }
                map[nextRow][nextCol]  = '*';
                tempRow = nextRow;
                tempCol = nextCol;
            }
            number--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
    }
}
