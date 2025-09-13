package cote.study.stackQ03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SolutionTestt {
	@Test
	void 테스트_케이스가_성공한다() {
		String s1 = "mirkovC4nizCC44";
		String s2 = "C4";
		String expected = "mirkovniz";

		String result = Solution.logic(s1, s2);

		assertEquals(expected, result);
	}
}
