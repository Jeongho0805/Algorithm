package _23년8월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * https://www.acmicpc.net/problem/13334
 */
public class 철로_골드2 {

    static class Pair {
        private int left;
        private int right;
        public Pair (int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> pairList = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairList.add(new Pair(Math.min(a,b), Math.max(a,b)));
        }

        pairList.sort(Comparator.comparingInt(p -> p.right));
        int d = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i=0; i<pairList.size(); i++) {
            int start = pairList.get(i).left;
            int end = pairList.get(i).right;
            if (end - start > d) { // 길이가 d 이상일 경우 pq에 삽입 x
                continue;
            }
            while (!pq.isEmpty()) {
                if (pq.peek() < end - d) {
                    pq.poll();
                } else {
                    break;
                }
            }
            pq.add(start);
            answer = Math.max(answer, pq.size());

        }
        System.out.println(answer);
    }
}
