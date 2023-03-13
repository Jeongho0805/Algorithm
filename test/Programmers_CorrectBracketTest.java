import _23년3월1째주.Programmers_CorrectBracket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Programmers_CorrectBracketTest {

    private Programmers_CorrectBracket solution = new Programmers_CorrectBracket();

    @Test
    void test1() {
        String input = "()()";
        boolean result = solution.solution(input);
        assertTrue(result);
    }

    @Test
    void test2() {
        String input = "(())()";
        boolean result = solution.solution(input);
        assertTrue(result);
    }

    @Test
    void test3() {
        String input = ")()(";
        boolean result = solution.solution(input);
        assertFalse(result);
    }

    @Test
    void test4() {
        String input = "(()(";
        boolean result = solution.solution(input);
        assertFalse(result);
    }
}