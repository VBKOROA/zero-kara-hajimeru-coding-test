package cote.study.dpQ02;

public class Solution {

    public int solution(int[] page_values, int[][] synergies) {
        int[] dp = new int[page_values.length];

        dp[0] = page_values[0];

        for(int i = 1; i < page_values.length; i++) {
            int bestValue = page_values[i];
            for(int j = 0; j < i; j++) {
                int combinedValue = dp[j]+page_values[i]+synergies[j][i];
                if (combinedValue > bestValue) {
                    bestValue = combinedValue;
                }
            }
            dp[i] = bestValue;
        }

        return dp[dp.length - 1];
    }
}