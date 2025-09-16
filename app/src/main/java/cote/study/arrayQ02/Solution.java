package cote.study.arrayQ02;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] blocks) {
        int maxLength = 0;

        int currentSum = 0;

        // 누적합 : 인덱스
        Map<Integer, Integer> sumMap = new HashMap<>();

        sumMap.put(0, -1);

        for(int i = 0; i < blocks.length; i++) {
            currentSum += blocks[i];
            if(sumMap.containsKey(currentSum)) {
                int length = i - sumMap.get(currentSum);
                maxLength = Math.max(maxLength, length);
            } else {
                // 최대 길이를 구하는 문제임으로
                // 누적합의 index를 매번 업데이트하면 안됨
                sumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }
}
