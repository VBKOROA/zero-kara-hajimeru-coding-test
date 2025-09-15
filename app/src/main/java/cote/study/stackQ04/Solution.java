package cote.study.stackQ04;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean solution(int[] departure_order) {

        int departureLength = departure_order.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int departureIndex = 0;

        if (departureLength <= 2) {
            return true;
        }

        for (int i = 1; i <= departureLength; i++) {
            stack.push(i);

            while (stack.isEmpty() == false
                    && stack.peek() == departure_order[departureIndex]) {
                stack.pop();
                departureIndex++;
            }
        }

        return stack.isEmpty();
    }
}
