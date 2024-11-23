package past._23년백준풀이._23년9월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/23971
 */
public class ZOAC4_브론즈3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int curR = 1;
        int curC = 1;
        int height = 0;
        int width = 0;
        while (curR <= h) {
            height++;
            curR += n+1;
        }
        while (curC <= w) {
            width++;
            curC += m+1;
        }
        System.out.println(width * height);
    }
}
