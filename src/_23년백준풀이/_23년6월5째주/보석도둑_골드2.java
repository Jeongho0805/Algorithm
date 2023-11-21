package _23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1202
 * 이분 탐색 해도 시간 초과 뜨네..
 *
 */
public class 보석도둑_골드2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Jewrly> jewrlyList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewrlyList.add(new Jewrly(weight, value));
        }

        int[] bags = new int[k];
        for (int i=0; i<k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        jewrlyList.sort(Comparator.comparingInt(o -> o.weight));
        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Jewrly> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);
        int idx = 0;

        for (int i=0; i<k; i++) {


//            while (idx < n && jewrlyList.get(idx).weight <= bags[i]) {
//                pq.add(jewrlyList.get(idx++));
//            }

//            위에 코드랑 무슨차이지 도대체..? -> 밑에서 weight 가 항상 bags[i] 보다 작으면 idx 초기화가 안되서 생기는 문제...
//
            for (int j=idx; j<n; j++) {
                if (jewrlyList.get(j).weight <= bags[i]) {
                    pq.add(jewrlyList.get(j));
                    idx++;
                } else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll().price;
            }
        }
        System.out.println(answer);

    }
    static class Jewrly {
        private int weight;
        private int price;

        public Jewrly(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}