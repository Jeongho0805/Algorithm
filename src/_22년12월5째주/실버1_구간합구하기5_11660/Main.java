package _22년12월5째주.실버1_구간합구하기5_11660;

import java.io.*;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

/**
 * 링크 - https://www.acmicpc.net/problem/11660
 * 복습 날짜 : 2023-01-01
 *
 * 처음에 풀었을 때 단순하게 다 더하는 방식으로 접근했음
 * 시간 초과가 나는 이유는 최대 행열 갯수가 1024 * 1024 = 1,048,560 임 여기서 최대 연산 횟수 100,000 을 곱하면 ? 1000억번 연산 해야함.. -> 1000초 걸리는 의미
 * 이런 문제는 dp로 접근하는게 바람직함
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 입 출력 갯수가 많으므로 buffered 쓰는게 유리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 dp 배열 완성
        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        // 연산 시작
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
            sb.append(answer+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}