package past._23년백준풀이._23년1월3째주.실버2_한줄로서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/1138
 * 풀이 날짜 : 2023-01-19
 * 풀이 보고 푼 문제 -> 골드 4보다 실버 2가 더 어렵다니,,, 복습 철저!
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lines = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            lines[i+1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=lines.length-1; i>0; i--) {
            answer.add(lines[i], i);
        }
        StringBuilder sb = new StringBuilder();
        answer.stream().forEach(number -> sb.append(number).append(" "));
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
