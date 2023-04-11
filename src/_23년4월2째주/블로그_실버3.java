package _23년4월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/21921
 */
public class 블로그_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] visitNumbers = new int[x];
        st = new StringTokenizer(br.readLine());
        boolean isSad = true;
        for (int i=0; i<x; i++) {
            visitNumbers[i] = Integer.parseInt(st.nextToken());
            if (visitNumbers[i] != 0) {
                isSad = false;
            }
        }
        if (isSad) {
            System.out.println("SAD");
        }
        else if (n==1) {
            int answer = 0;
            for (int i=0; i<=visitNumbers.length; i++) {
                answer = Math.max(visitNumbers[i], answer);
            }
            System.out.println(answer);
        }
        else {
            int sum = 0;
            int count = 1;
            for (int i=0; i<n; i++) {
                sum += visitNumbers[i];
            }
            int max = sum;
            int start = 0;
            int end = n;
            while (end < x) {
                sum -= visitNumbers[start];
                sum += visitNumbers[end];
                if (sum == max)  {
                    count++;
                } else if (sum > max) {
                    max = sum;
                    count = 1;
                }
                start++;
                end++;
            }
            System.out.println(max);
            System.out.println(count);
        }
    }
}
