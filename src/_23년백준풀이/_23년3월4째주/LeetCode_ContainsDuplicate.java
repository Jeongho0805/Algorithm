package _23년백준풀이._23년3월4째주;

import java.util.Arrays;

/**
 * 링크 - https://leetcode.com/problems/contains-duplicate/
 */
public class LeetCode_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
