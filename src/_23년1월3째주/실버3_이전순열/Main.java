package _23년1월3째주.실버3_이전순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/10973
 * 풀이 날짜 : 2023-01-20
 * 왜 이렇게 이해가 안되지,,, 우선 외워서 풀자
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int i = numbers.length-1;
        while (i > 0) {
            if (numbers[i-1] > numbers[i]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            System.out.println(-1);
        } else {
            int j = numbers.length-1;
            while (j >= i) {
                if (numbers[i-1] > numbers[j]) {
                    break;
                }
                j--;
            }
            swap(i-1, j, numbers);

            int start = i;
            int end = numbers.length-1;
            while (start < end) {
                swap(start, end, numbers);
                start++;
                end--;
            }
            Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
        }
    }

    private static void swap(int index1, int index2, int[] numbers) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
