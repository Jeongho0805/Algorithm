package boj2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2839 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = -1;

        for (int i = n / 5; i >= 0; i--) {
            int remaining = n - (5 * i);
            if (remaining % 3 == 0) {
                result = i + (remaining / 3);
                break;
            }
        }

        System.out.println(result);
    }
}

//        int[] answer = new int[n+1];
//
//
//
//        answer[1] = -1;
//        answer[2] = -1;
//        answer[3] = 1;
//        for (int i=4; i<=n; i++) {
//            if (i % 5 == 0) {
//                answer[i] = i / 5;
//                continue;
//            }
//            if (i - 3 >= 1 && answer[i - 3] != -1) {
//                answer[i] = Math.max(answer[i], answer[i-3] + 1);
//            }
//            if (i - 5 >= 1 && answer[i - 5] != -1) {
//                answer[i] = Math.max(answer[i], answer[i-5] + 1);
//            }
//            if (answer[i] == 0) {
//                answer[i] = -1;
//            }
//        }
//        System.out.println(answer[n]);

