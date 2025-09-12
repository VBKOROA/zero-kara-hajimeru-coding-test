package cote.study.stackQ02;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int solution(int[] ingredient) {
		int[] correctPattern = new int[]{1,2,3,1};
		int burger = 0;

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		for(int i : ingredient) {
			int currentCorrect = stack.peek();
			if(i == correctPattern[currentCorrect]) {
				if (currentCorrect == correctPattern.length - 1) {
					stack.pop();
					burger++;
				} else if (currentCorrect == 0) {
					stack.push(1);
			 	}else {
					stack.push(stack.pop() + 1);
				}
			} else {
				if (i == 1) {
					stack.push(1);
				}
			}
		}

		return burger;
	}
}