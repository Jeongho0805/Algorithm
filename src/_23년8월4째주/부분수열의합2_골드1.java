package _23년8월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1208
 *
 * https://lotuslee.tistory.com/84 -> 가장 깔끔한 설명
 */
public class 부분수열의합2_골드1 {

    static List<Integer> left = new ArrayList<>();
    static List<Integer> right = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        getSumList(0, 0, n/2, left, nums);
        getSumList(0, n/2, n, right, nums);

        left.sort(Comparator.comparingInt(o -> o));
        right.sort(Comparator.comparingInt(o -> o));

        int leftIdx = 0;
        int rightIdx = right.size()-1;
        long answer = 0;


        while (leftIdx < left.size() && rightIdx >= 0) {
            int sum = left.get(leftIdx) + right.get(rightIdx);
            if (sum < s) {
                leftIdx++;
            }
            else if (sum > s) {
                rightIdx--;
            }
            else {
                int value1 = left.get(leftIdx);
                long leftCount = 0;
                while (leftIdx < left.size() && left.get(leftIdx) == value1) {
                    leftCount++;
                    leftIdx++;
                }

                int value2 = right.get(rightIdx);
                long rightCount = 0;
                while (rightIdx >= 0 && right.get(rightIdx) == value2) {
                    rightCount++;
                    rightIdx--;
                }
                answer += leftCount * rightCount;
            }
        }

        if (s == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    private static void getSumList(int sum, int start, int end, List<Integer> left, int[] nums) {
        if (start == end) {
            left.add(sum);
            return;
        }
        getSumList(sum + nums[start], start+1, end, left, nums);
        getSumList(sum, start+1, end, left, nums); // 아무 것도 안넣는 경우
    }
}
