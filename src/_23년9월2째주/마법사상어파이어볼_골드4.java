package _23년9월2째주;


import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/20056
 */
public class 마법사상어파이어볼_골드4 {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static Stack<Fireball> stack = new Stack<>();
    static HashMap<String, List<Fireball>> map = new HashMap<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            stack.push(new Fireball(r, c, m, s, d));
        }

        while (K -- > 0) {

            while (!stack.isEmpty()) {
                Fireball fireball = stack.pop();
                fireball.move();
                int r = fireball.r;
                int c = fireball.c;
                String key = r + "," + c;

                if (map.containsKey(key)) {
                    map.get(key).add(fireball);
                } else {
                    List<Fireball> fireballs = new ArrayList<>();
                    fireballs.add(fireball);
                    map.put(key, fireballs);
                }
            }

            // map에 있는 fireball 꺼내서 중복되어있는지 확인하기
            for (String key : map.keySet()) {
                List<Fireball> fireballs = map.get(key);
                if (fireballs.size() == 1) {
                    stack.push(fireballs.get(0));
                } else {
                    int newWeight = calWeight(fireballs);
                    // 질량이 0이면 다음 key로 넘어가기
                    if (newWeight == 0) {
                        continue;
                    }
                    int newVelocity = calVelocity(fireballs);

                    if (isEqualDirection(fireballs)) {
                        for (int i=0; i<=6; i+=2) {
                            stack.push(new Fireball(fireballs.get(0).r, fireballs.get(0).c, newWeight, newVelocity, i));
                        }
                    } else {
                        for (int i=1; i<=7; i+=2) {
                            stack.push(new Fireball(fireballs.get(0).r, fireballs.get(0).c, newWeight, newVelocity, i));
                        }
                    }
                }
            }
            map.clear();
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop().m;
        }
        System.out.println(answer);
    }

    public static int calVelocity(List<Fireball> fireballs) {
        int totalVelocity = 0;
        for (int i=0; i<fireballs.size(); i++) {
            totalVelocity += fireballs.get(i).s;
        }
        return totalVelocity / fireballs.size();
    }

    public static int calWeight(List<Fireball> fireballs) {
        int totalWeight = 0;
        for (int i=0; i<fireballs.size(); i++) {
            totalWeight += fireballs.get(i).m;
        }
        return totalWeight / 5;
    }

    public static boolean isEqualDirection(List<Fireball> fireballs) {
        int temp = fireballs.get(0).d % 2;
        for (int i=1; i<fireballs.size(); i++) {
            int d = fireballs.get(i).d % 2;
            if (temp != d) {
                return false;
            }
        }
        return true;
    }

    static class Fireball {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void move() {
            int nextR = this.r + dr[d] * s;
            int nextC = this.c + dc[d] * s;
            if (nextR < 0) {
                nextR = N + nextR % N;
            }
            if (nextR >= N) {
                nextR = nextR % N;
            }
            if (nextC < 0) {
                nextC = N + nextC % N;
            }
            if (nextC >= N) {
                nextC = nextC % N;
            }
            this.r = nextR;
            this.c = nextC;
        }
    }
}
