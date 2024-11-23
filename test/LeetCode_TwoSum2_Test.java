import past._23년백준풀이._23년2월4쨰주.LeetCode_TwoSum2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_TwoSum2_Test {

    private LeetCode_TwoSum2 solution = new LeetCode_TwoSum2();

    @Test
    void test1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        assertArrayEquals(result, new int[]{1, 2});
    }

    @Test
    void test2() {
        int[] numbers = {2, 3, 4};
        int target = 6;
        int[] result = solution.twoSum(numbers, target);
        assertArrayEquals(result, new int[]{1, 3});
    }

    @Test
    void test3() {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] result = solution.twoSum(numbers, target);
        assertArrayEquals(result, new int[]{1, 2});
    }
}