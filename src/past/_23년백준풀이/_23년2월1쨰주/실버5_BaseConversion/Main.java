package past._23년백준풀이._23년2월1쨰주.실버5_BaseConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/11576
 * 풀이 날자 : 2023-02-02
 * 와씨.. 겨우 풀었네 -> 다른 풀이 방법 보기
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int number = 0;
        for (int i=n-1; i>=0; i--) {
            int multiply = 1;
            for (int j=0; j<i; j++) {
                multiply *= A;
            }
            number += multiply * Integer.parseInt(st.nextToken());
        }


        int maxCount = 0;
        int value = 1;
        while (true) {
            if (number / value >= B) {
                value *= B;
                maxCount++;
                continue;
            }
            break;
        }

        StringBuilder sb = new StringBuilder();
        while(maxCount -- >= 0) {
            int start = 1;
            for (int i=0; i<=maxCount; i++) {
                start *= B;
            }
            int share = number / start;
            sb.append(share + " ");
            number -= share * start;
        }
        System.out.println(sb);
    }
}
