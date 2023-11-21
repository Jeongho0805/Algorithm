package _23년백준풀이._23년5월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/15655
 */
public class N과M6_실버3 {

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        ArrayList<Integer> temp = new ArrayList<>();
        pickNumber(nums, size, temp, -1);
        System.out.println(answer);
    }

    private static void pickNumber(int[] nums, int size, ArrayList<Integer> temp, int idx) {
        if (temp.size() == size) {
            for (Integer num : temp) {
                answer.append(num + " ");
            }
            answer.delete(answer.length()-1, answer.length());
            answer.append("\n");
            return;
        }

        if (idx + 1 > nums.length-1) {
            return;
        }

        for (int i=idx+1; i<nums.length; i++) {
            temp.add(nums[i]);
            pickNumber(nums, size, temp, i);
            temp.remove(temp.size()-1);
        }
    }
}
