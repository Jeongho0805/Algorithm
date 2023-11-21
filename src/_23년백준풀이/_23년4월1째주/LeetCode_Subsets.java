package _23년백준풀이._23년4월1째주;

import java.util.ArrayList;
import java.util.List;

/**
 * 링크 - https://leetcode.com/problems/subsets/
 * 테스트 코드 작성 방법 물어보기 (순서 상관 없이 비교)
 */
public class LeetCode_Subsets {
    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        answer.add(new ArrayList<>()); // 빈 배열 넣기
        dfs(nums, 0,  new ArrayList<>());
        return answer;
    }

    private void dfs(int[] nums, int startIdx, ArrayList<Integer> subset) {
        for (int i=startIdx; i<nums.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>(subset);
            temp.add(nums[i]);
            answer.add(temp);
            dfs(nums, i+1, temp);
        }
    }
}
