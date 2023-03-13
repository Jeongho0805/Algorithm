package _23년1월1째주.골드2_가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 원래 풀이방법과 다르게 인덱스로 때려 맞춰서 풀어보기 -> stream 하면 큐의 정렬이 깨진다. 적정 인덱스 값 찾기가 불가능..
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            int number = Integer.parseInt(br.readLine());
            pq.add(number);
            int index = 0;
            if (pq.size() % 2 == 0) {
                index = (pq.size()/2) -1;
            } else if (pq.size() == 1) {
                index = 0;
            } else {
                index = pq.size()/2;
            }
            pq.stream().forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
        System.out.println(sb);
    }
}
