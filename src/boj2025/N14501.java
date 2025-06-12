package boj2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/14501
 */
public class N14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        int[] money = new int[n];
        int[] result = new int[n+1];

        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            time[i] = Integer.parseInt(line[0]);
            money[i] = Integer.parseInt(line[1]);
        }
        for (int i=0; i<n; i++) {
            if (i + time[i] <= n) {
                result[i+time[i]] = Math.max(result[i + time[i]], result[i] + money[i]);
            }
            result[i + 1] = Math.max(result[i + 1], result[i]);
        }
        int max = 0;
        for (int i=0; i<=n; i++ ) {
            max  = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}
