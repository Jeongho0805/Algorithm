import past._23년백준풀이._23년3월3째주.Programmers_MakeBigNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Programmers_MakeBigNumberTest {

    private final Programmers_MakeBigNumber problem = new Programmers_MakeBigNumber();

    @Test
    void test1() {
        String input = "4177252841";
        int k = 4;
        String result = problem.solution(input, k);

        assertEquals( "775841", result);
    }
}