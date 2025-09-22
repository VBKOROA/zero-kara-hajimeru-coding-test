package cote.study.treeQ01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스가_성공한다() {
        String[] dependencies = new String[] {
            "B A", "C A", "D B", "E B", "F C"
        };
        String targetService = "A";
        String[] expected = new String[] {"A", "B", "C", "D", "E", "F"};

        assertArrayEquals(expected, solution.solution(dependencies, targetService));
    }
}
