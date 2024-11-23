package past._23년백준풀이._23년2월1쨰주.실버4_학생번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 링크 - https://www.acmicpc.net/problem/1235
 * 풀이 날찌 : 2023-02-01
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] numbers = new String[n];
        for (int i=0; i<n; i++) {
            numbers[i] = br.readLine();
        }

        int answer = 0;
        for (int i=numbers[0].length()-1; i>=0; i--) {
            answer++;
            HashSet<String> set = new HashSet<>();
            for (String number : numbers) {
                set.add(number.substring(i));
            }
            if (set.size() == n) {
                break;
            }
        }
        System.out.println(answer);
    }
}
