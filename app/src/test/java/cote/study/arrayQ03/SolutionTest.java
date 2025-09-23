package cote.study.arrayQ03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스가_성공한다() {
        int length = 10;
        int[][] sensors = new int[][] {
            {0, 3},
            {2, 2},
            {6, -3},
            {7, 1},
        };
        int expected = 3;

        assertEquals(expected, solution.solution(length, sensors));
    }
}
