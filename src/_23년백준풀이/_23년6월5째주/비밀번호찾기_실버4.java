package _23년백준풀이._23년6월5째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17219
 */
public class 비밀번호찾기_실버4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> passwords = new HashMap<>();
        while (n-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            passwords.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String site = br.readLine();
            String password = passwords.get(site);
            sb.append(password).append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}
