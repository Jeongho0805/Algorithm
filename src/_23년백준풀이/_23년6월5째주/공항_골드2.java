package _23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10775
 */
public class 공항_골드2 {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G+1];
        for (int i=0; i<=G; i++) {
            parents[i] = i;
        }

        int answer = 0;
        for (int i=0; i<P; i++) {
            int g = Integer.parseInt(br.readLine());
            int x = find(g);
            if (x == 0) {
                break;
            }
            union(x, x-1);
            answer++;
        }
        System.out.println(answer);
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[x] = y;
        }
    }
}
