package past._23년백준풀이._23년3월3째주.실버2_최대힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 문제 링크 - https://www.acmicpc.net/problem/11279
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                    continue;
                }
                sb.append(pq.poll() + "\n");
                continue;
            }
            pq.add(number);
        }
        System.out.println(sb);
    }
}
