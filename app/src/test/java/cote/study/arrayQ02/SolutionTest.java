package cote.study.arrayQ02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스를_성공한다() {
        int[] testCase = new int[]{2, 3, -5, 1, 4, -5};

        assertEquals(6, solution.solution(testCase));
    }   
}
