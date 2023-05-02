package _23년5월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/1449
 */
public class 수리공항승_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] location = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(location);

        int[] diff = new int[n-1];
        for (int i=0; i<location.length-1; i++) {
            diff[i] = location[i+1] - location[i];
        }

        int answer = 1;
        int surplus = l-1;

        for (int i=0; i<diff.length; i++) {
            if (diff[i] <= surplus) {
                surplus -= diff[i];
            } else {
                answer++;
                surplus = l-1;
            }
        }
        System.out.println(answer);
    }
}
