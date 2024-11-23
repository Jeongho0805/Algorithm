package past._23년백준풀이._23년1월1째주.골드5_A와B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 링크 - https://www.acmicpc.net/problem/12919
 * 풀이 날자 : 2023-01-04
 * 이전에 한번 풀어본 문제! 혹시 다른 풀이 방법도 있는지 파악해보기
 *
 * 복습 날짜 : 2023-01-08
 */
public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String preWord = br.readLine();
        String postWord = br.readLine();
        StringBuilder sb = new StringBuilder(postWord);
        isPossible(preWord, sb);
        System.out.println(answer);
    }

    private static void isPossible(String preWord, StringBuilder sb) {
        if (sb.length() == preWord.length()) {
            if (sb.toString().equals(preWord)) {
                answer = 1;
            }
            return;
        }

        char lastWord = sb.charAt(sb.length()-1);
        char firstWord = sb.charAt(0);
        if (lastWord == 'A') {
            sb.deleteCharAt(sb.length()-1);
            isPossible(preWord, sb);
            sb.append(lastWord);
        }
        if (firstWord == 'B') {
            sb.reverse();
            sb.deleteCharAt(sb.length()-1);
            isPossible(preWord, sb);
            sb.append(firstWord);
            sb.reverse();
        }
    }
}


//public class Main {
//
//    static int answer;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String beforeWord = br.readLine();
//        String afterWord = br.readLine();
//
//        StringBuilder sb = new StringBuilder(afterWord);
//        dfs(beforeWord, sb);
//        System.out.println(answer);
//
//    }
//    private static void dfs(String beforeWord, StringBuilder sb) {
//        if (sb.length() == beforeWord.length()) {
//            if (beforeWord.equals(sb.toString())) {
//                answer = 1;
//            }
//            return;
//        }
//
//        if (sb.charAt(sb.length()-1) == 'A') {
//            sb.deleteCharAt(sb.length()-1);
//            dfs(beforeWord, sb);
//            sb.append('A');
//        }
//
//        if (sb.charAt(0) == 'B') {
//            sb.reverse().deleteCharAt(sb.length()-1);
//            dfs(beforeWord, sb);
//            sb.append('B');
//            sb.reverse();
//        }
//    }
//}
