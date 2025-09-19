package cote.study.simulationQ01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스가_성공한다() {
        String[] grid = new String[] {
            "V.V",
            "...",
            "..."
        };

        String[] expected = new String[] {
            "V.V",
            "V.V",
            "V.V"
        };

        assertArrayEquals(expected, solution.solution(grid));
    }
}
