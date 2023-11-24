import _23년백준풀이._23년3월4째주.LeetCode_ContainsDuplicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_ContainsDuplicateTest {

    private LeetCode_ContainsDuplicate problem = new LeetCode_ContainsDuplicate();

    @Test
    void test1() {
        int[] nums = {1,2,3,1};
        boolean result = problem.containsDuplicate(nums);
        assertTrue(result);
    }

    @Test
    void test2() {
        int[] nums = {1,2,3,4};
        boolean result = problem.containsDuplicate(nums);
        assertFalse(result);
    }

    @Test
    void test3() {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = problem.containsDuplicate(nums);
        assertTrue(result);
    }
}