package _23년8월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11049
 */
public class 행렬곱셈순서_골드3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] process = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            process[i][0] = Integer.parseInt(st.nextToken());
            process[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int len=1; len<N; len++) {
            for(int i=0; i+len<N; i++) {
                dp[i][i+len] = Integer.MAX_VALUE;
                for(int j=i; j<i+len; j++) {
                    dp[i][i+len] = Math.min(dp[i][i+len], dp[i][j]+dp[j+1][i+len] + process[i][0]*process[j][1]*process[i+len][1]);
                }
            }
        }
//        System.out.println("===========dp배열================");
//        for (int i=0; i<dp.length; i++) {
//            for (int j=0; j<dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[0][N-1]);
    }
}

