package past._23년백준풀이._23년6월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/14405
 */
public class 피카츄_브론즈1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String answer = "YES";
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == 'p') {
                if (i+1 > word.length()-1) {
                    answer = "NO";
                    break;
                }
                if (word.charAt(i+1) == 'i') {
                    i++;
                    continue;
                }
            }
            if (word.charAt(i) == 'k') {
                if (i+1 > word.length()-1) {
                    answer = "NO";
                    break;
                }
                if (word.charAt(i+1) == 'a') {
                    i++;
                    continue;
                }
            }
            if (word.charAt(i) == 'c') {
                if (i+2 > word.length()-1) {
                    answer = "NO";
                    break;
                }
                if (word.charAt(i+1) == 'h' && word.charAt(i+2) == 'u') {
                    i+=2;
                    continue;
                }
            }
            answer = "NO";
            break;
        }
        System.out.println(answer);
    }
}
