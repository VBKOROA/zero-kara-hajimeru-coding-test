package cote.study.greedyQ01;

import java.util.PriorityQueue;

public class Solution {
    public long solution(int[] dryingTimes, int[] importanceScores) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((first, second) -> {
            // 0 - drying
            // 1 - importance
            return Float.compare(first[0]/(float)first[1], second[0]/(float)second[1]);
            // 더 나은 방법 (직한님 최고)
            // long val1 = (long)first[0] * second[1];
            // long val2 = (long)second[0] * first[1];
            // long으로 캐스팅하여 오버플로우 방지
            // return Long.compare(val1, val2);
        });

        for(int i = 0; i < dryingTimes.length; i++) {
            int[] cloth = new int[]{dryingTimes[i], importanceScores[i]};
            priorityQueue.add(cloth);
        }
        
        int currentTotalDryingTimes = 0;
        long result = 0L;

        while(priorityQueue.isEmpty() == false) {
            // 0 - drying
            // 1 - importance
            int[] cloth = priorityQueue.poll();
            currentTotalDryingTimes += cloth[0];
            result += currentTotalDryingTimes * cloth[1];
        }

        return result;
    }
}
