package cote.study.setQ01;

import java.util.*;

public class Solution {
	public List<Integer> solution(int[] existing_frequencies, int[] candidate_frequencies) {
		Set<Integer> existingSet = new HashSet<>();
		for (int freq : existing_frequencies) {
			existingSet.add(freq);
		}

		List<Integer> goldenFrequencies = new ArrayList<>();

		for (int candidate : candidate_frequencies) {
			if (!existingSet.contains(candidate - 1) &&
				!existingSet.contains(candidate) &&
				!existingSet.contains(candidate + 1)) {
				goldenFrequencies.add(candidate);
			}
		}

		goldenFrequencies.sort(null);

		return goldenFrequencies;
	}
}
