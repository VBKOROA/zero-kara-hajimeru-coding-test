package cote.study.heapQ01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 예제1을_성공한다() {
        int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = solution.solution(scoville, K);

        assertEquals(2, result);
    }
}
