package past._22년12월5째주.골드5_빗물_14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/14719
 * 풀이 참고해서 푼 문제
 *
 * 복습 날짜 : 2023-01-01
 * 어떻게 이런 풀이를 떠올리는거지?.. 대단하다
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] blocks = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=1; i<w; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j=0; j<i; j++) {
                leftMax = Math.max(leftMax, blocks[j]);
            }
            for (int j=i+1; j<w; j++) {
                rightMax = Math.max(rightMax, blocks[j]);
            }
            int result = Math.min(leftMax, rightMax) - blocks[i];
            if (result > 0) {
                sum += result;
            }
        }
        System.out.println(sum);
    }
}
