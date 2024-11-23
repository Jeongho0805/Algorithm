package past._23년백준풀이._23년1월2째주.실버3_숫자야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/2503
 * 풀이 날짜 : 2023-01-13
 * 풀이 참고하고 푼 문제
 * 무슨 실버3 문제가 이렇게 어렵냐,,, 구현 문제 진짜 많이 풀어봐야 할 듯 ㅜㅜ
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] info = new int[n][3];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = findCase(info);
        System.out.println(answer);
    }

    private static int findCase(final int[][] infos) {
        int count = 0;
        for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                root : for (int k=1; k<10; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    for (int[] info : infos) {
                        int strike = 0;
                        int ball = 0;
                        int target = info[0];
                        int hunderd = target / 100;
                        int ten = (target % 100) / 10;
                        int one = (target % 10);

                        if (hunderd == i) {
                            strike++;
                        } else if (hunderd == j || hunderd == k) {
                            ball++;
                        }

                        if (ten == j) {
                            strike++;
                        } else if (ten == i || ten == k) {
                            ball++;
                        }

                        if (one == k) {
                            strike++;
                        } else if (one == i || one == j) {
                            ball++;
                        }

                        if (strike == info[1] && ball == info[2]) {
                            continue;
                        } else {
                            continue root;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
