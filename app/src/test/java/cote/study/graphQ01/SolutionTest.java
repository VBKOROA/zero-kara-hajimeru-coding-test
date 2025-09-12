package cote.study.graphQ01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    void 예제를_성공한다() {
        List<int[]> test = List.of(
            new int[]{1, 2},
            new int[]{1, 3},
            new int[]{2, 4},
            new int[]{4, 5}
        );

        Solution solution = new Solution();

        String result = solution.solution(5, test, 1, 2);

        assertEquals("YES", result);
    }
}
