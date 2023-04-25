package _23년4월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 링크 - https://www.acmicpc.net/problem/11508
 */
public class 세일_실버4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> milks = new ArrayList<>();
        for (int i=0; i<n; i++) {
            milks.add(Integer.parseInt(br.readLine()));
        }
        milks.sort((o1, o2) -> o2 - o1);
        int idx = 1;
        int total = 0;
        for (int milk : milks) {
            if (idx == 3) {
                idx = 1;
                continue;
            }
            total += milk;
            idx++;
        }
        System.out.println(total);
    }
}
