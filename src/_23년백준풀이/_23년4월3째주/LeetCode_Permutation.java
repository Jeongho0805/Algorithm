package _23년백준풀이._23년4월3째주;

import java.util.ArrayList;
import java.util.List;

/**
 * 링크 - https://leetcode.com/problems/permutations/
 */
public class LeetCode_Permutation {
    private final List<List<Integer>> answer = new ArrayList<>();
    private boolean[] visited;
    private int maxSize = 0;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        maxSize = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(temp, nums);
        return answer;
    }

    private void dfs(ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == maxSize) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                dfs(temp, nums);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
