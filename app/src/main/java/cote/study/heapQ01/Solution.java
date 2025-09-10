package cote.study.heapQ01;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        if (scoville[1] == 0) {
            return -1;
        }

        Arrays.stream(scoville)
                .forEach(heap::add);

        int cnt = 0;

        while (heap.peek() < K) {
            if (heap.size() == 1) {
                return -1;
            }

            int first = heap.poll();
            int second = heap.poll();

            if (cnt == 0 && second == cnt) {
                return -1;
            }

            int finaly = first + second * 2;

            heap.add(finaly);

            cnt++;
        }

        return cnt;
    }
}
