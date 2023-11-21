package _23년백준풀이._23년1월2째주.실버5_방번호;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 링크 - https://www.acmicpc.net/problem/1475
 * 풀이 날짜 : 2023-01-14
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> countMap = new HashMap<>();
        String number = sc.nextLine();

        for (int i=0; i<number.length(); i++)  {
            if (number.charAt(i) == '9') {
                countMap.put('6', countMap.getOrDefault('6', 0) + 1);
                continue;
            }
            countMap.put(number.charAt(i), countMap.getOrDefault(number.charAt(i), 0) + 1);
        }
        if (countMap.get('6') != null) {
            int value = countMap.get('6');
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = value / 2 + 1;
            }
            countMap.put('6', value);
        }
        int answer = 0;
        for (Integer value : countMap.values()) {
            answer = Math.max(answer, value);
        }
        System.out.println(answer);
    }
}
