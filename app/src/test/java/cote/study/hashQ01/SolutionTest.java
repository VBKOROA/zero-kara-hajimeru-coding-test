package cote.study.hashQ01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Nested
    class 완주하지_못한_선수 {
        @Test
        void 예시1을_성공한다() {
            String[] participant = new String[] { "leo", "kiki", "eden" };
            String[] completion = new String[] { "eden", "kiki" };

            String result = solution.solution(participant, completion);

            assertEquals("leo", result);
        }

        @Test
        void 예시2를_성공한다() {
            String[] participant = new String[] { "marina", "josipa", "nikola", "vinko", "filipa" };
            String[] completion = new String[] { "josipa", "filipa", "marina", "nikola" };

            String result = solution.solution(participant, completion);

            assertEquals("vinko", result);
        }

        @Test
        void 예시3을_성공한다() {
            String[] participant = new String[] { "mislav", "stanko", "mislav", "ana" };
            String[] completion = new String[] { "stanko", "ana", "mislav" };

            String result = solution.solution(participant, completion);

            assertEquals("mislav", result);
        }
    }

}
