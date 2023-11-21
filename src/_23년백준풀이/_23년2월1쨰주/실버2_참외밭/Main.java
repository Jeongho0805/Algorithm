package _23년백준풀이._23년2월1쨰주.실버2_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 링크 - https://www.acmicpc.net/problem/2477
 * 풀이 날짜 : 2023-02-03
 * 생각보다 너무 어려웠던 문제,,,
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] length = new int[6];
        int[] direction = new int[6];

        for (int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int maxWidth = 0;
        int maxLengthIndex = -1;
        int maxWidthIndex = -1;

        for (int i=0; i<6; i++) {
            if (direction[i] == 1 || direction[i] == 2) {
                if (maxLength < length[i]) {
                    maxLengthIndex = i;
                    maxLength = length[i];
                }
            } else {
                if (maxWidth < length[i]) {
                    maxWidthIndex = i;
                    maxWidth = length[i];
                }
            }
        }

        int minusWidth = 0;
        int minusLength = 0;

        if (maxLengthIndex == 0) {
            minusWidth = Math.abs(length[5] - length[1]);
        } else if (maxLengthIndex == 5) {
            minusWidth = Math.abs(length[4] - length[0]);
        } else {
            minusWidth = Math.abs(length[maxLengthIndex-1] - length[maxLengthIndex+1]);
        }

        if (maxWidthIndex == 0) {
            minusLength = Math.abs(length[5] - length[1]);
        } else if (maxWidthIndex == 5) {
            minusLength = Math.abs(length[4] - length[0]);
        } else {
            minusLength = Math.abs(length[maxWidthIndex-1] - length[maxWidthIndex+1]);
        }

        int total = maxWidth * maxLength;
        int minusValue = minusWidth * minusLength;
        System.out.println(n * (total - minusValue));
    }
}
