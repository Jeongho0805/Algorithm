package _23년백준풀이._23년8월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18512
 * [ 고민 과정 ]
 * 탐색을 어디까지 해야 될지 정하는게 핵심인것 같은데.. 감을 못잡겠네
 */
public class 점프점프_브론즈1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<10000/x; i++) {
            set.add(i*x + p1);
        }

        int answer = -1;
        for (int i=0; i<10000/y; i++) {
            int nextP = p2 + y*i;
            if (set.contains(nextP)) {
                answer = nextP;
                break;
            }
        }

        System.out.println(answer);


    }
}
