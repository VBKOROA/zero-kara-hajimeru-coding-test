package cote.study.stackQ01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Nested
    class 같은_숫자는_싫어 {
        @Test
        void 예제1을_성공한다() {
            int[] arr = new int[] { 1, 1, 3, 3, 0, 1, 1 };
            int[] expected = new int[] { 1, 3, 0, 1 };

            int[] result = solution.solution(arr);

            assertArrayEquals(expected, result);
        }

        @Test
        void 예제2를_성공한다() {
            int[] arr = new int[] { 4, 4, 4, 3, 3 };
            int[] expected = new int[] { 4, 3 };

            int[] result = solution.solution(arr);

            assertArrayEquals(expected, result);
        }
    }
}
