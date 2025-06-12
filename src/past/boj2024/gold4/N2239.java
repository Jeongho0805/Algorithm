package past.boj2024.gold4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2239 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 1;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i=1; i<n; i++) {
            if (dp[idx - 1] < arr[i]) {
                dp[idx] = arr[i];
                idx++;
            }
            else {
                int left = 0;
                int right = idx - 1;
                int target = arr[i];
                while (left < right) {
                    int mid = ( left + right ) / 2;
                    if (dp[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = target;
            }
        }
        System.out.println(idx);
    }
}
