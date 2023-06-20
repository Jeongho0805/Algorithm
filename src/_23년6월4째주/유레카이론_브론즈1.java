package _23년6월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10448
 */
public class 유레카이론_브론즈1 {
    public static void main(String[] args) throws IOException {

        int[] triNums = new int[45];
        for (int i=1; i<45; i++) {
            triNums[i] = triNums[i-1] + i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            int result = 0;
            int sum = 0;
            root : for (int i=1; i<45; i++) {
                for (int j=1; j<45; j++) {
                    for (int k=1; k<45; k++) {
                        sum = triNums[i] + triNums[j] + triNums[k];
                        if (sum == number) {
                            result = 1;
                            break root;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
