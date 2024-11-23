package past._23년백준풀이._23년5월4째주;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class Programmers_두큐같게만들기 {
    public int solution(int[] queue1, int[] queue2) {

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        if ((sum1 + sum2) % 2 == 1) { // 전체 합이 홀수이면 return -1
            return -1;
        }

        Queue<Integer> queueOne = new LinkedList<>();
        Queue<Integer> queueTwo = new LinkedList<>();
        for (int num : queue1) {
            queueOne.add(num);
        }
        for (int num : queue2) {
            queueTwo.add(num);
        }

        int maxCount = queue1.length + queue2.length;
        int count = 0;

        while (count <= maxCount * 2) { // maxCount일 경우 안되는 이유?
            if (sum1 < sum2) {
                int num = queueTwo.poll();
                queueOne.add(num);
                sum1 += num;
                sum2 -= num;
            }
            else if (sum1 > sum2) {
                int num = queueOne.poll();
                queueTwo.add(num);
                sum1 -= num;
                sum2 += num;
            }
            else { // sum1과 sum2가 같을 경우 return count
                return count;
            }
            count++;
        }
        return -1; // count > maxCount 일 경우 return -1
    }
}
