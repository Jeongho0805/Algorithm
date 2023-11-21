package _23년백준풀이._23년1월2째주.Programmers_게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 풀이 날짜 : 2023-01-14
 */
public class Main {
    public static void main(String[] args) {

        int[][] map = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        Solution s = new Solution();
        int result = s.solution(map);
        System.out.println(result);
    }
}

class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(final int[][] maps) {

        Queue<int[]> queue = new LinkedList<>();
        int[] firstInfo = {0, 0};
        queue.add(firstInfo);

        int[][] shortMap = new int[maps.length][maps[0].length];
        shortMap[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int currentRow = info[0];
            int currentCol = info[1];

            // 0, 0
            // (0, -1) (0, 1) (1,0) (-1,0)
            for (int i=0; i<4; i++) {
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];

                if (nextRow < 0 || nextCol < 0 || nextRow >= maps.length || nextCol >= maps[0].length) {
                    continue;
                }
                if (maps[nextRow][nextCol] == 1 && shortMap[nextRow][nextCol] == 0) {
                    shortMap[nextRow][nextCol] = shortMap[currentRow][currentCol] + 1;
                    int[] newInfo = {nextRow, nextCol};
                    queue.add(newInfo);
                }
            }
        }

        int destination = shortMap[shortMap.length-1][shortMap[0].length-1];
        if (destination == 0) {
            return -1;
        }
        return destination;
    }
}
