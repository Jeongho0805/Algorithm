package past._23년백준풀이._23년2월1쨰주.Programmers_입국심사;

import java.util.Arrays;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
 * 풀이 날짜 : 2023-02-04
 * 풀이 참고해서 푼 문제
 */
public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        Solution s = new Solution();
        long result = s.solution(n, times);
        System.out.println(result);
    }
}

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long start = 0;
        long end = (long) times[times.length-1] * n;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum >= n) {
                answer = Math.min(mid, answer);
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return answer;
    }
}
