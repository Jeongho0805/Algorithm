package past._22년12월5째주.실버1_절댓값힙_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 링크 - https://www.acmicpc.net/problem/11286
 * 복습 날짜 : 2023-01-01
 * 중요한 점은 절댓값이 같을 경우도 고려해줘야 한다!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int O1 = Math.abs(o1);
                int O2 = Math.abs(o2);
                if (O1 > O2) {
                    return 1;
                }else if (O1 < O2) {
                    return -1;
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(priorityQueue.poll());
                }
                continue;
            }
            priorityQueue.add(number);
        }
    }
}
