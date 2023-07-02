package _23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/19238
 */
public class 스타트택시_골드2 {

    static int[][] map;
    static boolean[] visitedIdx;
    static List<Passenger> passengersList = new ArrayList<>();
    static int[] dr = {-1, 0, 1 ,0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int oil = Integer.parseInt(st.nextToken());

        visitedIdx = new boolean[m+2];
        map = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Taxi taxi = new Taxi(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, oil);

        passengersList.add(null);
        passengersList.add(null);
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            Passenger passenger = new Passenger(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            passengersList.add(passenger);
        }

        for (int i=2; i<passengersList.size(); i++) {
            Passenger passenger = passengersList.get(i);
            map[passenger.startR][passenger.startC] = i;
        }
        
        int passengerCount = 0;
        boolean isImpossible = false;

        while (passengerCount < m) {
            int idx = findMinDistancePassenger(taxi);
            if (idx == -1) { // 승객 찾으러 갈 떄 연료 바닥날 경우
                isImpossible = true;
                break;
            }

            boolean isPossible = DriveToDestination(taxi, passengersList.get(idx));
            if (!isPossible) {
                isImpossible = true;
                break;
            }

            passengerCount++;
        }

        if (isImpossible) {
            System.out.println(-1);
        } else {
            System.out.println(taxi.oil);
        }

    }

    private static boolean DriveToDestination(Taxi taxi, Passenger passenger) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{taxi.r, taxi.c, 0});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[taxi.r][taxi.c] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int curR = info[0];
            int curC = info[1];
            int cost = info[2];

            if (curR == passenger.endR && curC == passenger.endC) {
                if (taxi.oil < cost) {
                    return false;
                }
                taxi.r = passenger.endR;
                taxi.c = passenger.endC;
                taxi.plusOil(cost);
                return true;
            }

            for (int i=0; i<4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) {
                    continue;
                }

                if (map[nextR][nextC] == 1 || visited[nextR][nextC]) {
                    continue;
                }
                visited[nextR][nextC] = true;
                queue.add(new int[]{nextR, nextC, cost+1});
            }
        }

        return false;
    }


    private static int findMinDistancePassenger(Taxi taxi) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{taxi.r, taxi.c, 0});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[taxi.r][taxi.c] = true;

        List<int[]> idxInfoList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int curR = info[0];
            int curC = info[1];
            int cost = info[2];

            int value = map[curR][curC];
            if (value > 1  && !visitedIdx[value]) {
                if (idxInfoList.isEmpty()) {
                    idxInfoList.add(new int[]{value, cost});
                } else {
                    int[] prevIdxInfo = idxInfoList.get(idxInfoList.size() - 1);
                    if (prevIdxInfo[1] < cost) {
                        break;
                    } else {
                        idxInfoList.add(new int[]{value, cost});
                    }
                }
            }

            for (int i=0; i<4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map[0].length) {
                    continue;
                }

                if (map[nextR][nextC] == 1 || visited[nextR][nextC]) {
                    continue;
                }
                visited[nextR][nextC] = true;
                queue.add(new int[]{nextR, nextC, cost+1});
            }
        }
        if (idxInfoList.isEmpty()) {
            return -1;
        }

        idxInfoList.sort((o1, o2) -> {
            int r1 = passengersList.get(o1[0]).startR;
            int r2 = passengersList.get(o2[0]).startR;
            int c1 = passengersList.get(o1[0]).startC;
            int c2 = passengersList.get(o2[0]).startC;

            if (r1 > r2) {
                return 1;
            }
            else if (r1 < r2) {
                return -1;
            } else {
                return c1 - c2;
            }
        });

        int idx = idxInfoList.get(0)[0];
        taxi.consumeOil(idxInfoList.get(0)[1]);
        Passenger passenger = passengersList.get(idx);
        taxi.r = passenger.startR;
        taxi.c = passenger.startC;
        visitedIdx[idx] = true;
        return idx;
    }

    static class Passenger {

        int startR;
        int startC;
        int endR;
        int endC;

        public Passenger(int startR, int startC, int endR, int endC) {
            this.startR = startR;
            this.startC = startC;
            this.endR = endR;
            this.endC = endC;
        }
    }

    static class Taxi {
        int r;
        int c;
        int oil;

        public Taxi(int r, int c, int oil) {
            this.r = r;
            this.c = c;
            this.oil = oil;
        }

        public void consumeOil(int cost) {
            this.oil -= cost;
        }

        public void plusOil(int cost) {
            this.oil += cost;
        }
    }
}
