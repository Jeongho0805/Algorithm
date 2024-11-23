package past._23년백준풀이._23년1월1째주.LeetCode_111;


/**
 * 링크 - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 풀이 날짜 - 2023-01-06
 * 풀이 참고하고 푼 문제
 *
 * 복습 날짜 : 2023-01-08
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution s = new Solution();
        int answer = s.minDepth(root);
        System.out.println(answer);
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
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
