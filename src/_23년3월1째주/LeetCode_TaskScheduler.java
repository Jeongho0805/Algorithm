package _23년3월1째주;

import java.util.*;

/**
 * 링크 - https://leetcode.com/problems/task-scheduler/
 * 풀이 참고한 문제
 */
public class LeetCode_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] alphabets = new int[26];
        for (char task : tasks) {
            alphabets[task - 'A']++;
        }
        for (int i=0; i<26; i++) {
            if (alphabets[i] == 0) {
                continue;
            }
            pq.add(alphabets[i]);
        }

        HashMap<Integer, Integer> idleMap = new HashMap<>();
        int time = 0;
        while (!idleMap.isEmpty() || !pq.isEmpty()) {
            if (idleMap.containsKey(time-n-1)) {
                pq.add(idleMap.remove(time-n-1));
            }
            if (!pq.isEmpty()) {
                int left = pq.poll()-1;
                if (left != 0) {
                    idleMap.put(time, left);
                }
            }
            time++;
        }
        return time;
    }
}