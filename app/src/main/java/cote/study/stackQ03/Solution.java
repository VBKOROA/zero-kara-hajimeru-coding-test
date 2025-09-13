package cote.study.stackQ03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		System.out.println(logic(s1, s2));
	}

	public static String logic(String s1, String s2) {
		char[] originalCharArray = s1.toCharArray();
		char[] bombPattern = s2.toCharArray();

		Deque<Character> stack = new ArrayDeque<>();
		Deque<Integer> stackForPatternMatching =  new ArrayDeque<>();
		stackForPatternMatching.push(0);

		for(char c : originalCharArray) {
			stack.push(c);
			Integer currentIdx = stackForPatternMatching.peek();
			if (c == bombPattern[currentIdx]) {
				if (currentIdx == 0) {
					stackForPatternMatching.push(1);
				} else {
					stackForPatternMatching.push(stackForPatternMatching.pop() + 1);
				}

				if (currentIdx == bombPattern.length - 1) {
					stackForPatternMatching.pop();
					for(int i = 0; i < bombPattern.length; i++) {
						stack.pop();
					}
				}
			} else {
				if(c == bombPattern[0]) {
					stackForPatternMatching.push(1);
				} else {
					stackForPatternMatching.push(0);
				}
			}
		}

		if(stack.isEmpty()) {
			return "FRULA";
		}

		StringBuilder result = new StringBuilder();

		while(stack.isEmpty() == false) {
			result.append(stack.pollLast());
		}

		return result.toString();
	}
}
