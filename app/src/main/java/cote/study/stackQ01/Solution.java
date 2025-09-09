package cote.study.stackQ01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(deque.peek() != arr[i]) {
                deque.push(arr[i]);
            }
        }

        int[] result = new int[deque.size()];
        for(int i = deque.size() - 1; i >= 0; i--) {
            result[i] = deque.pop();
        }
        return result;
    }
}
