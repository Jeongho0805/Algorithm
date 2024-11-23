package past._23년백준풀이._23년2월1쨰주.실버5_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/11723
 * 풀이 날짜 : 2023-02-03
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int number = 0;
            if (!order.equals("all") && !order.equals("empty")) {
                number = Integer.parseInt(st.nextToken());
            }

            if (order.equals("add")) {
                set.add(number);
                continue;
            }
            if (order.equals("remove")) {
                set.remove(number);
                continue;
            }
            if (order.equals("check")) {
                if (set.contains(number)) {
                    sb.append(1+"\n");
                } else {
                    sb.append(0+"\n");
                }
                continue;
            }
            if (order.equals("toggle")) {
                if (set.contains(number)) {
                    set.remove(number);
                } else {
                    set.add(number);
                }
                continue;
            }
            if (order.equals("all")) {
                for (int i=1; i<=20; i++) {
                    set.add(i);
                }
                continue;
            }
            if (order.equals("empty")) {
                set.clear();
            }
        }
        if (sb.length() > 0) {
            sb.delete(sb.length()-1, sb.length());
        }
        System.out.println(sb);
    }
}
