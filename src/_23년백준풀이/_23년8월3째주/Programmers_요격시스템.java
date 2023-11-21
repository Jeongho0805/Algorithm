package _23년백준풀이._23년8월3째주;

import java.util.Arrays;

public class Programmers_요격시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            else {
                return o2[1] - o1[1];
            }
        });
        int answer = 0;
        int end = -1;
        for (int[] target : targets) {
            if (target[0] < end) {
                if (target[1] < end) {
                    end = target[1];
                }
                continue;
            }
            end = target[1];
            answer++;
        }
        return answer;
    }
}
