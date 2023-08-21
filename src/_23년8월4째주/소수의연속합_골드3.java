package _23년8월4째주;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1644
 */
public class 소수의연속합_골드3 {

    public static final int MAX_NUM = 4_000_000;

    public static void main(String[] args) throws IOException {

        boolean[] primes = new boolean[MAX_NUM + 1];
        List<Integer> primeList = new ArrayList<>();
        /* 왜 밑에 로직으로는 4000000 이하의 모든 소수를 못구할까? */
//        for (int i=2; i*i<=MAX_NUM; i++) {
//            if (!primes[i]) {
//                primeList.add(i);
//                for (int j=i*i; j<= MAX_NUM; j+=i) {
//                    primes[j] = true;
//                }
//            }
//        }
        for (int i = 2; i <= MAX_NUM; i++) {
            if (!primes[i]) {
                primeList.add(i);
                for (int j = i * 2; j <= MAX_NUM; j += i) {
                    primes[j] = true;
                }
            }
        }
//        System.out.println(primeList.size());
        int[] count = new int[MAX_NUM + 1];
        for (int i=0; i<primeList.size(); i++) {
            int value = primeList.get(i);
            count[value]++;
            for (int j=i+1; j<primeList.size(); j++) {
                value += primeList.get(j);
                if (value > MAX_NUM) break;
                count[value]++;
            }
        }
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(count[target]);
    }
}
