package _23년백준풀이._23년9월2째주;


import java.util.Arrays;

public class Programmers_구명보트 {
        public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            answer++;
            int total = people[right--];
            if (total + people[left] <= limit) {
                left++;
            }
        }
        return answer;
    }
}
