package cote.study.queueQ02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스가_성공한다() {
        int[] priorities = new int[] {2, 1, 3, 2};
        int location = 3;

        assertEquals(2, solution.solution(priorities, location));
    }
}
