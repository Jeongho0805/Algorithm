package _23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1764
 */
public class 듣보잡_실버4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> names = new HashSet<>();
        while (n-- > 0 ) {
            names.add(br.readLine());
        }
        int count = 0;
        List<String> nameList = new ArrayList<>();
        while (m -- >0) {
            String name = br.readLine();
            if (names.contains(name)) {
                nameList.add(name);
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count + "\n");
        Collections.sort(nameList);
        for (String name : nameList) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
