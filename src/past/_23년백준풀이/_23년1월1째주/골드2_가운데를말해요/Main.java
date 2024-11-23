package past._23년백준풀이._23년1월1째주.골드2_가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 링크 - https://www.acmicpc.net/problem/1655
 * 풀이 날짜 : 2023-01-05
 * 우선순위 큐 두개 활용해서 풀면 된다고하는데,,, 그냥 pq에 다 때려넣고 중간 인덱스값을 구하면 안되나?
 * 풀이 참고 하고 푼 문제 -> 복습하기!
 *
 * 복습 날짜 : 2023-01-08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        StringBuilder answer = new StringBuilder();
        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (minQueue.size() == maxQueue.size()) {
                maxQueue.add(number);
            } else {
                minQueue.add(number);
            }

            if (!minQueue.isEmpty() && !minQueue.isEmpty()) {
                if (minQueue.peek() < maxQueue.peek()) {
                    int temp = minQueue.poll();
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(temp);
                }
            }

            answer.append(maxQueue.peek()+"\n");
        }
        System.out.println(answer);
    }
}




//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i=0; i<n; i++) {
//            int input = Integer.parseInt(br.readLine());
//            if (minQueue.size() == maxQueue.size()) {
//                maxQueue.add(input);
//            } else {
//                minQueue.add(input);
//            }
//            if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
//                if (maxQueue.peek() > minQueue.peek()) {
//                    int temp = maxQueue.poll();
//                    maxQueue.add(minQueue.poll());
//                    minQueue.add(temp);
//                }
//            }
//            sb.append(maxQueue.peek()+"\n");
//        }
//        System.out.println(sb);
//    }
//}
