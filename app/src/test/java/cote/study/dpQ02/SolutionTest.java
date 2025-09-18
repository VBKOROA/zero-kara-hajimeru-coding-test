package cote.study.dpQ02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스가_성공한다() {
        int[] page_values = new int[] {10, 20, 5, 30};
        int[][] synergies = new int[][] {
            {0, 5, 1, 20},
            {0, 0, 8, 7},
            {0, 0, 0, 10},
            {0, 0, 0, 0}
        };

        assertEquals(88, solution.solution(page_values, synergies));
    }
}
