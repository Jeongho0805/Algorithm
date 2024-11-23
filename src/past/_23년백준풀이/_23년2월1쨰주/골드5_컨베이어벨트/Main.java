package past._23년백준풀이._23년2월1쨰주.골드5_컨베이어벨트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 링크 - https://www.acmicpc.net/problem/20055
 * 풀이 날짜 : 2023-02-01
 * 시발 좆같은 문제... 틀린 문제..
 */
public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] belt;
    static ArrayList<Robot> robots = new ArrayList<>();
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2][n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                belt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            answer++;
            Collections.sort(robots, (o1, o2) -> o2.getPosition() - o1.getPosition());
            rotateBelt();
            moveRobot();
            addRobot();
//            debugBelt();
            if (isStopToMove()) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void debugBelt() {
        for (int i=0; i<2; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(belt[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isStopToMove() {
        int count = 0;
        for (int i=0; i<2; i++) {
            for (int j=0; j<n; j++) {
                if (belt[i][j] == 0) {
                    count++;
                }
            }
        }
        if (count >= k) {
            return true;
        }
        return false;
    }

    private static void addRobot() {
        if (belt[0][0] == 0) {
            return;
        }
        List<Integer> positions = robots.stream().map(Robot::getPosition).collect(Collectors.toList());
        if (positions.contains(0)) {
            return;
        }
        belt[0][0]--;
        robots.add(new Robot());
    }

    private static void moveRobot() {
        List<Integer> afterMovePos = new ArrayList<>();
        ArrayList<Robot> removes = new ArrayList<>();
        for (Robot robot : robots) {
            int col = robot.getPosition() + 1;
            int value = belt[0][col];
            if (afterMovePos.contains(col)) {
                continue;
            }
            if (value == 0) {
                continue;
            }
            robot.move();
            belt[0][col]--;
            if (robot.getPosition() >= n-1) {
                removes.add(robot);
                continue;
            }
            afterMovePos.add(robot.getPosition());
        }
        robots.removeAll(removes);
    }


    private static void rotateBelt() {
        int prevRow = 0;
        int prevCol = 0;
        int direction = 0;
        int value = belt[prevRow][prevCol];
        while (direction < 4) {
            int nextRow = prevRow + dr[direction];
            int nextCol = prevCol + dc[direction];
            if (nextRow >= 2 || nextRow < 0 || nextCol >= n || nextCol < 0) {
                direction++;
                continue;
            }
            int temp = belt[nextRow][nextCol];
            belt[nextRow][nextCol] = value;
            value = temp;
            prevRow = nextRow;
            prevCol = nextCol;
        }

        ArrayList<Robot> removes = new ArrayList<>();
        for (Robot robot : robots) {
            robot.move();
            if (robot.getPosition() >= n-1) {
                removes.add(robot);
            }
        }
        robots.removeAll(removes);
    }
}

class Robot {
    
    int position = 0;
    
    public int getPosition() {
        return this.position;
    }
    
    public void move() {
        position++;
    }
}



