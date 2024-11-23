package past._23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/19532
 */
public class 수학은비대면강의입니다_브론즈2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        root: for (int x=-999; x<=999; x++) {
            for (int y=-999; y<=999; y++) {
                if (a*x + b*y == c && d*x + e*y == f) {
                    sb.append(x).append(" ").append(y);
                    break root;
                }
            }
        }
        System.out.println(sb);
    }
}
