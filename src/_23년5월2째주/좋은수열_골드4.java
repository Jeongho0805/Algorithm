package _23년5월2째주;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2661
 */
public class 좋은수열_골드4 {

    static boolean isComplete = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        makeNumber(n, new StringBuilder());
    }

    private static void makeNumber(int n, StringBuilder number) {
        if (isComplete) {
            return;
        }

        if (number.length() == n) {
            System.out.println(number);
            isComplete = true;
            return;
        }

        for (int i=1; i<=3; i++) {
            number.append(i);
            if (isPossibleNumber(number)) {
                makeNumber(n, number);
            }
            number.delete(number.length()-1, number.length());
        }
    }

    private static boolean isPossibleNumber(StringBuilder number) {
        if (number.length() == 1) {
            return true;
        }
        int halfLength = number.length() / 2;
        for (int i=1; i<=halfLength; i++) {
            if (number.substring(number.length() - i*2, number.length()-i).equals(number.substring(number.length() - i))) {
                return false;
            }
        }
        return true;
    }
}
