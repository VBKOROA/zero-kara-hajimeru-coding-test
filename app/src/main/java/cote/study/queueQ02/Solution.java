package cote.study.queueQ02;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> prQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> indexQueue = new ArrayDeque<>();

        for(int i = 0; i < priorities.length; i++) {
            indexQueue.offer(i);
            prQueue.offer(priorities[i]);
        }

        int maxSize = indexQueue.size();

        for(int i = 0; i < maxSize; i++) {
            int priority = prQueue.peek();
            while(priorities[indexQueue.peek()] != priority) {
                indexQueue.offer(indexQueue.poll());
            }
            if(indexQueue.peek() == location) {
                // 1-based return
                return i+1;
            }
            indexQueue.poll();
            prQueue.poll();
        }

        return 0;
    }
}
