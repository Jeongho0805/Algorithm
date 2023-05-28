package _23년5월4째주;

import java.util.Arrays;

/**
 *  https://leetcode.com/problems/unique-paths/
 */
public class LeetCode_UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
