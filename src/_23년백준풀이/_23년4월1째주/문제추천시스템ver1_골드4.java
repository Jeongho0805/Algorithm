package _23년백준풀이._23년4월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/21939
 * - 엣지케이스 고려해보기 지훈님이 말씀한
 */
public class 문제추천시스템ver1_골드4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Problem> minQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDifficulty() > o2.getDifficulty()) {
                return 1;
            } else if (o1.getDifficulty() < o2.getDifficulty()) {
                return -1;
            } else {
                return o1.getNo() - o2.getNo();
            }
        });
        PriorityQueue<Problem> maxQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDifficulty() > o2.getDifficulty()) {
                return -1;
            } else if (o1.getDifficulty() < o2.getDifficulty()) {
                return 1;
            } else {
                return o2.getNo() - o1.getNo();
            }
        });

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            minQueue.add(new Problem(no, difficulty));
            maxQueue.add(new Problem(no, difficulty));
        }
        ArrayList<Integer> solvedList = new ArrayList<>();

        int orderCount = Integer.parseInt(br.readLine());
        while(orderCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("add")) {
                int no = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                minQueue.add(new Problem(no, difficulty));
                maxQueue.add(new Problem(no, difficulty));
            } else if (order.equals("solved")) {
                solvedList.add(Integer.parseInt(st.nextToken()));
            } else {
                int number = Integer.parseInt(st.nextToken());
                while(true) {
                    if (number == 1) {
                        Problem problem = maxQueue.peek();
                        if (solvedList.contains(problem.getNo())) {
                            minQueue.remove(problem);
                            maxQueue.remove(problem);
                            solvedList.remove(Integer.valueOf(problem.getNo()));
                            continue;
                        }
                        System.out.println(problem.getNo());
                    } else {
                        Problem problem = minQueue.peek();
                        if (solvedList.contains(problem.getNo())) {
                            minQueue.remove(problem);
                            maxQueue.remove(problem);
                            solvedList.remove(Integer.valueOf(problem.getNo()));
                            continue;
                        }
                        System.out.println(problem.getNo());
                    }
                    break;
                }
            }
        }
    }
}

class Problem {
    private final int no;

    private final int difficulty;

    public Problem(int no, int difficulty) {
        this.no = no;
        this.difficulty = difficulty;
    }

    public int getNo() {
        return no;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
