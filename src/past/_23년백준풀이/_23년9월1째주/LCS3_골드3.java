package past._23년백준풀이._23년9월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2개 lcs 구하고 -> 나머지 1개 구하는 방식은 반례가 존재한다
 * dababcf
 * ababdef
 * df
 * 다음과 같을 떄 정답은 2이지만 해당 풀이 방식으로 하면 1이 나온다.
 *
 * 3차원 dp 배열을 활용해야 한다는데.. 원리가 뭔지 감을 못잡겠다.
 * https://www.acmicpc.net/problem/1958
 */
public class LCS3_골드3 {

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();
        char[] word3 = br.readLine().toCharArray();

        dp = new int[word1.length + 1][word2.length + 1][word3.length + 1];

        for(int i = 1; i <= word1.length; i++) {
            for(int j = 1; j <= word2.length; j++) {
                for (int k = 1; k <= word3.length; k++) {
                    // (i-1)번째 문자 == (j-1)번째 문자 == (k-1)번째 문자
                    if(word1[i - 1] == word2[j - 1] && word2[j - 1] == word3[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    }
                    else {
                        //이전 열(i-1)과 이전 행(j-1), (k-1)의 값 중 큰 것으로 갱신
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                Math.max(dp[i][j - 1][k], dp[i][j][k - 1])
                        );
                    }

                }
            }
        }
        System.out.println(dp[word1.length][word2.length][word3.length]);
    }
}





//public class LCS3_골드3 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String word1 = "-" + br.readLine();
//        String word2 = "-" + br.readLine();
//        String word3 = "-" + br.readLine();
//
//        // 유효성 검증이 빡세서 0이 아닌 1부터 시작하는구나..
//        int[][] map = new int[word1.length()][word2.length()];
//        for (int i=1; i<word1.length(); i++) {
//            for (int j=1; j<word2.length(); j++) {
//                if (word1.charAt(i) == word2.charAt(j)) {
//                    map[i][j] = map[i-1][j-1] + 1;
//                }
//                else {
//                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
//                }
//            }
//        }
//        /* 역순으로 순회하면서 LCS를 어떻게 찾을까? -> DFS 사용안해도 될거같은데..*/
//        StringBuilder lcs = new StringBuilder();
//        int endRow = word1.length() - 1;
//        int endCol = word2.length() - 1;
//        while (map[endRow][endCol] > 0) {
//            if (map[endRow][endCol - 1] == map[endRow][endCol]) {
//                endCol--;
//                continue;
//            }
//            if (map[endRow-1][endCol] == map[endRow][endCol]) {
//                endRow--;
//                continue;
//            }
//            /* 위 왼쪽 둘다 아니면 해당 위치 문자열 넣어주고 왼쪽 위 대각으로 이동 */
//            lcs.append(word1.charAt(endRow));
//            endRow--;
//            endCol--;
//        }
//
//        String temp = "-" + lcs.reverse();
//        map = new int[temp.length()][word3.length()];
//        for (int i=1; i<temp.length(); i++) {
//            for (int j=1; j<word3.length(); j++) {
//                if (temp.charAt(i) == word3.charAt(j)) {
//                    map[i][j] = map[i-1][j-1] + 1;
//                }
//                else {
//                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
//                }
//            }
//        }
//        System.out.println(map[temp.length()-1][word3.length()-1]);
//    }
//}
