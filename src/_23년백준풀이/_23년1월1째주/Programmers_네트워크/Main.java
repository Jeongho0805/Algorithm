package _23년백준풀이._23년1월1째주.Programmers_네트워크;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 풀이 날짜 : 2023-01-06
 *
 * 복습 날짜 : 2023-01-08
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int n = 3;
        int result = s.solution(n, computers);
        System.out.println(result);
    }
}
/*
0 -  1     /      2

1 1 0
1 1 0
0 0 1

answer = 0
check { flase, false false }


 */


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && !check[j]) {
                dfs(computers, j, check);
            }
        }
    }
}