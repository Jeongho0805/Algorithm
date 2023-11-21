package _23년백준풀이._23년5월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1629
 */
public class 곱셈_실버1 {
    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(calPow(a, b));
    }

    private static long calPow(long a, long b) {
        if (b == 1) {
            return a % c;
        }

        long half = calPow(a, b / 2);

        if (b % 2 == 1) {
            return (half * half % c) * a % c;
        }
        return half * half % c;
    }
}


