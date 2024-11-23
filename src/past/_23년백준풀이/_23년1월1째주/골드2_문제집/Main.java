package past._23년백준풀이._23년1월1째주.골드2_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/1766
 * 풀이 날짜 : 2023-01-05
 * 위상정렬 관련 문제 -> 꼭 다시 풀어보기
 *
 * 복습 날짜 : 2023-01-08
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int preNumber = Integer.parseInt(st.nextToken());
            int postNumber = Integer.parseInt(st.nextToken());
            indegree[postNumber]++;
            graph.get(preNumber).add(postNumber);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!pq.isEmpty()) {
            int current = pq.poll();
            answer.append(current + " ");

            ArrayList<Integer> problems = graph.get(current);
            for (Integer problem : problems) {
                indegree[problem]--;
                if (indegree[problem] == 0) {
                    pq.add(problem);
                }
            }
        }
        answer.deleteCharAt(answer.length()-1); // 마지막 공백 제거
        System.out.println(answer);
    }
}


//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        int[] indegree = new int[n+1]; // 진입차수 배열 선언
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 간선 정보 리스트 선언
//        for (int i=0; i<=n; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i=0; i<m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int preNumber = Integer.parseInt(st.nextToken());
//            int postNumber = Integer.parseInt(st.nextToken());
//            graph.get(preNumber).add(postNumber);
//            indegree[postNumber]++; // 진입차수 증가
//        }
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i=1; i<=n; i++) {
//            if (indegree[i] == 0) {
//                pq.add(i);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder(); // 출력을 위한 StringBuilder 선언
//        while(!pq.isEmpty()) {
//            int value = pq.poll();
//            sb.append(value + " ");
//            ArrayList<Integer> numbers = graph.get(value);
//            for (int number : numbers) {
//                indegree[number]--;
//                if (indegree[number] == 0) {
//                    pq.add(number); // 진입차수가 0인 노드 pq에 집어넣기
//                }
//            }
//        }
//        sb.deleteCharAt(sb.length()-1); // 뒤에 공백 문자 제거
//        System.out.println(sb);
//    }
//}
