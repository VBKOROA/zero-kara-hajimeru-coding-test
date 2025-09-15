package cote.study.stackQ04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스_1을_성공한다() {
        int[] departure_order = new int[]{4, 5, 3, 2, 1};
        assertTrue(solution.solution(departure_order));
    }

    @Test
    void 테스트_케이스_2를_성공한다() {
        int[] departure_order = new int[]{3, 1, 2, 4, 5};
        assertFalse(solution.solution(departure_order));
    }
}
