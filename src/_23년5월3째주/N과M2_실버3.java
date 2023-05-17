package _23년5월3째주;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15650
 */
public class N과M2_실버3 {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());

        findAnswer(n,m, 1, new ArrayList<Integer>());
        System.out.println(answer);
    }

    private static void findAnswer(int n, int m, int idx, ArrayList<Integer> list) {
        if (list.size() == m) {
            for (Integer num : list) {
                answer.append(num).append(" ");
            }
            answer.delete(answer.length()-1, answer.length());
            answer.append("\n");
            return;
        }
        for (int i = idx; i<=n; i++) {
            list.add(i);
            findAnswer(n, m, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
