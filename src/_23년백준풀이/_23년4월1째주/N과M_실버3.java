package _23년백준풀이._23년4월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  링크 - https://www.acmicpc.net/problem/15651
 */
public class N과M_실버3 {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            numbers.add(i);
            dfs(n, m, numbers);
            numbers.remove(numbers.size()-1);
        }
        answer.delete(answer.length()-1, answer.length());
        System.out.println(answer);
    }

    private static void dfs(int n, int m, ArrayList<Integer> numbers) {
        if (numbers.size() == m) {
            for (Integer number : numbers) {
                answer.append(number).append(" ");
            }
            answer.delete(answer.length()-1, answer.length());
            answer.append("\n");
            return;
        }
        for (int i=1; i<=n; i++) {
            numbers.add(i);
            dfs(n, m, numbers);
            numbers.remove(numbers.size()-1);
        }
    }
}
