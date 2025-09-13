package cote.study.stackQ02;

import org.junit.jupiter.api.Test;

public class SolutionTest {
	@Test
	void 테스트() {
		Solution solution = new Solution();
		int[] ingredients = new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1};
		solution.solution(ingredients);
	}
}
