package _23년2월1쨰주.실버5_분수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/1193
 * 풀이 날짜 : 2023-02-02
 * 실버 5인데 왤캐 어렵지? 풀이 참고한 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int crossCount = 1;
        int totalCount = 0;

        while (true) {
            if (n <= crossCount + totalCount) {
                if (crossCount % 2 == 0) {
                    System.out.println((n - totalCount) + "/" + (crossCount - (n - totalCount - 1)));
                    break;
                } else {
                    System.out.println((crossCount - (n - totalCount - 1) + "/" + (n - totalCount)));
                    break;
                }
            } else {
                totalCount += crossCount;
                crossCount++;
            }
        }
    }
}
