package past._22년12월5째주.실버4_한수_1065;

import java.util.Scanner;

/**
 * 링크 - https://www.acmicpc.net/problem/1065
 *  원래 풀이 : 메모리(17.38mb)  / 시간 (200ms)
 *  개선 풀이 : 메모리(17 mb ) / (시간 200ms)
 *  별 차이가 없네..
 *  복습 날짜 = 2023-01-01
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = count(n);
        System.out.println(answer);
    }

    private static int count(int n) {
        if (n < 100) {
            return n;
        }
        int count = 99;
        for (int i=100; i<=n; i++) {
            int hun = i % 10;
            int ten = (i / 10) % 10;
            int one = (i / 100);

            if ((hun - ten) == (ten - one)) {
                count++;
            }
        }
        return count;
    }
}

/* 원래 풀이 방식
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (isCorrect(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isCorrect(int n) {
        String number = String.valueOf(n);
        int diff = Integer.MIN_VALUE;
        for (int i=0; i<number.length()-1; i++) {
            int curDigit = number.charAt(i) - '0';
            int nextDigit = number.charAt(i+1) - '0';
            int diffCandidate = nextDigit - curDigit;
            if (diff == Integer.MIN_VALUE) {
                diff = diffCandidate;
                continue;
            }
            if (diff != diffCandidate) {
                return false;
            }
        }
        return true;
    }
}
*/