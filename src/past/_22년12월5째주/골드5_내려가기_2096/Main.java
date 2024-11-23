package past._22년12월5째주.골드5_내려가기_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2096
 * 메모리 제한 때문에 이차원 배열 선언 X -> 복습
 *
 * 복습 날짜 : 2023-01-01
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] maxValues = new int[3];
        int[] minValues = new int[3];
        int[] maxTempValues = new int[3];
        int[] minTempValues = new int[3];


        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) {
                for (int j=0; j<3; j++) {
                    int number = Integer.parseInt(st.nextToken());
                    maxValues[j] = number;
                    minValues[j] = number;
                }
                continue;
            }
            for (int j=0; j<3; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    maxTempValues[j] = Math.max(maxValues[j], maxValues[j+1]) + number;
                    minTempValues[j] = Math.min(minValues[j], minValues[j+1]) + number;
                    continue;
                }
                if (j == 2) {
                    maxTempValues[j] = Math.max(maxValues[j], maxValues[j-1]) + number;
                    minTempValues[j] = Math.min(minValues[j], minValues[j-1]) + number;
                    continue;
                }
                maxTempValues[j] = Math.max(Math.max(maxValues[j-1], maxValues[j]), maxValues[j+1]) + number;
                minTempValues[j] = Math.min(Math.min(minValues[j-1], minValues[j]), minValues[j+1]) + number;
            }
            for (int j=0; j<3; j++) {
                maxValues[j] = maxTempValues[j];
                minValues[j] = minTempValues[j];
            }
        }
        int maxValue = Arrays.stream(maxValues).max().getAsInt();
        int minValue = Arrays.stream(minValues).min().getAsInt();

        System.out.println(maxValue + " " + minValue);

    }
}
