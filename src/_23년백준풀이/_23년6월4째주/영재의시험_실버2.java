package _23년백준풀이._23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/19949
 * 2번 같은 문제를 무조건 찍어야 하는걸로 착각함..
 */
public class 영재의시험_실버2 {

    static int count = 0;
    static int[] problems = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<10; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, new ArrayList<>());
        System.out.println(count);
    }

    private static void dfs(int depth, int score, ArrayList<Integer> list) {
        if (depth == 10) {
            if (score >= 5) {
                count++;
            }
            return;
        }

//        if (depth > 5 && depth - score < 5) {
//            return;
//        }

        if (depth == 0 || depth == 1) {
            for (int i=1; i<=5; i++) {
                if (i == problems[depth]) {
                    list.add(i);
                    dfs(depth+1, score+1, list);
                    list.remove(list.size()-1);
                } else {
                    list.add(i);
                    dfs(depth+1, score, list);
                    list.remove(list.size()-1);
                }
            }
        }
        else {
            for (int i = 1; i <= 5; i++) {
                if (list.get(depth-1) == i && list.get(depth-2) == i) {
                    continue;
                }
                if (i == problems[depth]) {
                    list.add(i);
                    dfs(depth + 1, score + 1, list);
                    list.remove(list.size() - 1);
                } else {
                    list.add(i);
                    dfs(depth + 1, score, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
