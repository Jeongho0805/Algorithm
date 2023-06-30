package _23년4월3째주;

import java.util.Arrays;

/**
 * 링크 - https://leetcode.com/problems/house-robber/
 */

/**
 *
 * [2,7,9,3,1]
 * [2,7,11,10,12]
 *
 *
 */
public class LeetCode_HouseRober {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length < 2) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i=2; i<nums.length; i++) {
            if (i == 2) {
                dp[i] = nums[i] + dp[i-2];
                continue;
            }
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

