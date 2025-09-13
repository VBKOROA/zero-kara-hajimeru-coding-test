package cote.study.arrayQ01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스가_성공한다() {
        int[][] frame = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] command = new int[][] {
            {1, 1, 2, 1}
        };

        int[][] expected = new int[][]{
            {1, 2, 3, 4},
            {5, 10, 6, 8},
            {9, 11, 7, 12},
            {13, 14, 15, 16}
        };

        int[][] result = solution.solution(frame, command);

        assertArrayEquals(expected, result);
    }
}
