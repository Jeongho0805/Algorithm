package _23년백준풀이._23년1월2째주.실버5_요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/11866
 * 풀이 날짜 : 2023-01-14
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            numbers.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int interval = k-1;
        int index = k-1;
        while (numbers.size() != 0) {
            if (index >= numbers.size()) {
                index = index % numbers.size();
                continue;
            }
            sb.append(numbers.remove(index) + ", ");
            index += interval;
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
