package boj2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2110 {

    static int[] home;
    static int N;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for (int i=0; i<N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int left = 1;
        int right = home[N-1] - home[0];
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canBuild(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean canBuild(int distance) {
        int count = 1;
        int current = home[0];
        for (int i=1; i<home.length; i++) {
            if (home[i] - current >= distance) {
                count++;
                current = home[i];
            }
        }
        return count >= C;
    }
}


