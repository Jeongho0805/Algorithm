package _23년백준풀이._23년3월3째주;

import java.util.ArrayList;
import java.util.List;

/**
 * 링크 - https://leetcode.com/problems/path-sum-ii/
 */

public class LeetCode_PathSum2 {

    List<List<Integer>> answer;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        answer = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, new ArrayList<>(List.of(root.val)), targetSum);
        if (answer.size() == 0) {
            return new ArrayList<>();
        }
        return answer;
    }

    private void dfs(TreeNode root, ArrayList<Integer> temp, int targetSum) {
        int sum = calSum(temp);
        if (root.left ==null && root.right == null) {
            if (sum == targetSum) {
                answer.add(temp);
            }
            return;
        }

        if (root.left != null) {
            temp.add(root.left.val);
            dfs(root.left, new ArrayList<>(temp), targetSum);
            temp.remove(temp.size()-1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            dfs(root.right, new ArrayList<>(temp), targetSum);
            temp.remove(temp.size()-1);
        }
    }

    private int calSum(ArrayList<Integer> temp) {
        return temp.stream().mapToInt(Integer::intValue).sum();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



