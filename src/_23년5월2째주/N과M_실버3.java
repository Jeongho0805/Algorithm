package _23년5월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *  https://www.acmicpc.net/problem/2407
 */
public class N과M_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[m+1];
        int[] mod = new int[m+1];
        int temp = m;

        for (int i=1; i<=m; i++) {
            num[i] = n;
            mod[i] = temp;
            n--;
            temp--;
        }

        BigInteger total = BigInteger.ONE;
        BigInteger modTotal = BigInteger.ONE;
        for (int i=1; i<=m; i++) {
            total  = total.multiply(new BigInteger(String.valueOf(num[i])));
            modTotal = modTotal.multiply(new BigInteger(String.valueOf(mod[i])));
        }
        System.out.println(total.divide(modTotal));
    }
}
