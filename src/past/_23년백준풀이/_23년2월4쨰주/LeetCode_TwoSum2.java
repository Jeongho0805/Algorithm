package past._23년백준풀이._23년2월4쨰주;

public class LeetCode_TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int value = numbers[left] + numbers[right];

            if (value == target) {
                return new int[]{left+1, right+1};
            } else if (value < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
