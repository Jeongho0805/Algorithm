package _23년백준풀이._23년1월2째주.LeetCode_852;

/**
 * 링크 - https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * 풀이 날짜 : 2023-01-14
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        Solution s = new Solution();
        int answer = s.peakIndexInMountainArray(arr);
        System.out.println(answer);
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int preNumber = -1;
        int answer = 0;
        for (int i=0; i<arr.length; i++) {
            if (preNumber > arr[i]) {
                answer = i-1;
                break;
            }
            preNumber = arr[i];
        }
        return answer;
    }
}
