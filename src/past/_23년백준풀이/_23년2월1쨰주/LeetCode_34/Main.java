package past._23년백준풀이._23년2월1쨰주.LeetCode_34;


/**
 * 링크 - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 풀이날짜 : 2023-02-04
 */
public class Main {
    public static void main(String[] args) {

        int[] nums = {1,3,5,5,5,5,7};
        int target = 5;
        Solution s = new Solution();
        int[] result = s.searchRange(nums, target);

        System.out.println(result[0] + " " + result[1]);

    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int start = mid, end = mid;
                while (start > 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }
                result[0] = start;
                result[1] = end;
                return result;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}


class Fail {
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        int targetIndex = -1;

        while (true) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                targetIndex = mid;
                break;
            }
            if (target > nums[mid]) {
                start = mid+1;
                continue;
            }
            if (target < nums[mid]) {
                end = mid-1;
            }
        }

        if (targetIndex == -1) {
            return new int[]{-1, -1};
        }

        int startIndex = targetIndex;
        int endIndex = targetIndex;

        while (true) {
            if (startIndex-1 >= 0) {
                if (nums[startIndex-1] == nums[targetIndex]) {
                    startIndex--;
                    continue;
                }
            }
            break;
        }

        while (true) {
            if (endIndex+1 < nums.length) {
                if (nums[endIndex + 1] == nums[targetIndex]) {
                    endIndex++;
                    continue;
                }
            }
            break;
        }
        return new int[]{startIndex, endIndex};
    }
}
