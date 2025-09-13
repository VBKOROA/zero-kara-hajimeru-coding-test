package cote.study.setQ01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
	private final Solution solution = new Solution();

	@Test
	void 테스트_케이스가_성공한다() {
		int[] test1 = new int[] {100, 105, 110};
		int[] test2 = new int[] {98, 99, 104, 106, 109, 112};
		List<Integer> expected = List.of(98, 112);

		List<Integer> result = solution.solution(test1, test2);

		assertEquals(expected, result);
	}
}
