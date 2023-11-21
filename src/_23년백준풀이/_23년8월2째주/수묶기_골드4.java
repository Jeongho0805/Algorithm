package _23년백준풀이._23년8월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1744
 */
public class 수묶기_골드4 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> minusList = new ArrayList<>();
        ArrayList<Integer> plusList = new ArrayList<>();

        int answer = 0;

        while (n-- > 0 ) {
            int num = Integer.parseInt(br.readLine());
            if (num <=1) {
                minusList.add(num);
            } else {
                plusList.add(num);
            }
        }

        Collections.sort(plusList);
        if (plusList.size() % 2 == 0) {
            answer += calMultiplyValue(plusList);
        } else {
            answer += plusList.remove(0);
            answer += calMultiplyValue(plusList);
        }


        answer += calMultiplyMinusList(minusList);


        int count = countZero(minusList);
        minusList.sort((Comparator.comparingInt(o -> o)));
        changeMinusToZero(minusList, count);
        answer += minusList.stream().mapToInt(Integer::intValue).sum();

        System.out.println(answer);
    }

    private static void changeMinusToZero(ArrayList<Integer> minusList, int count) {
        for (int i=0; i<minusList.size(); i++) {
            if (minusList.get(i) >= 0 || count <= 0) {
                break;
            }
            minusList.set(i, 0);
            count--;
        }
    }

    private static int countZero(ArrayList<Integer> minusList) {
        return (int) minusList.stream().filter(num -> num == 0).count();
    }

    private static int calMultiplyValue(ArrayList<Integer> plusList) {
        int sum = 0;
        for (int i=0; i<plusList.size(); i = i+2) {
            sum += plusList.get(i) * plusList.get(i+1);
        }
        return sum;
    }

    private static long calMultiplyMinusList(ArrayList<Integer> minusList) {
        int sum = 0;
        minusList.sort(Collections.reverseOrder());
        for (int i=minusList.size()-1; i-1>=0; i= i-2) {
            if (minusList.get(i) < 0 && minusList.get(i-1) < 0) {
                sum += minusList.remove(i) * minusList.remove(i-1);
            }
        }
        return sum;
    }
}
