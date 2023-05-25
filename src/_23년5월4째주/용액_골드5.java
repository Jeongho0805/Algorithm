package _23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2467
 */
public class 용액_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = arr.length-1;

        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
