package cote.study.queueQ01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스_성공() {
        String[][] records = {
                { "입고", "삼각김밥", "20240501" },
                { "입고", "생수", "20240502" },
                { "입고", "삼각김밥", "20240503" },
                { "판매", "삼각김밥" },
                { "판매", "우유" },
                { "입고", "생수", "20240504" },
                { "판매", "생수" },
                { "판매", "삼각김밥" }
        };

        List<Integer> answer = List.of(20240501, -1, 20240502, 20240503);

        var result = solution.solution(records);

        System.out.println(result.toString());

        assertTrue(answer.equals(result));
    }
}
