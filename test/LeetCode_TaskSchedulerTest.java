import past._23년백준풀이._23년3월1째주.LeetCode_TaskScheduler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_TaskSchedulerTest {

    private LeetCode_TaskScheduler solution = new LeetCode_TaskScheduler();

    @Test
    void test1() {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int result = solution.leastInterval(tasks, n);
        assertEquals(8, result);
    }
}