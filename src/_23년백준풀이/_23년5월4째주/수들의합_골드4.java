package _23년백준풀이._23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2015
 */
public class 수들의합_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long answer = 0;
        int[] cumSum = new int[n+1];

        for (int i=1; i<=n; i++) {
            cumSum[i] = Integer.parseInt(st.nextToken()) + cumSum[i-1];
            if (cumSum[i] == k) {
                answer++;
            }
        }

        HashMap<Integer, Long> map = new HashMap<>();
        for (int i=1; i<=n; i++) {
            if (map.containsKey(cumSum[i] - k)) {
                answer += map.get(cumSum[i] - k);
            }

            if (map.containsKey(cumSum[i])) {
                map.put(cumSum[i], map.get(cumSum[i]) + 1);
            } else {
                map.put(cumSum[i], 1L);
            }
        }
        System.out.println(answer);
    }
}
