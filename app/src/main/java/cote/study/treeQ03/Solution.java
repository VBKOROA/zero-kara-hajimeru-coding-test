package cote.study.treeQ03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int solution(int[][] replies) {
        // replies[][0] = 댓글 ID
        // replies[][1] = 부모 ID

        Map<Integer, List<Integer>> replyMap = new HashMap<>();
        for (int[] reply : replies) {
            replyMap.computeIfAbsent(reply[1], k -> new ArrayList<>()).add(reply[0]);
        }

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] { 0, 1 });

        int maxDepth = 0;

        while (stack.isEmpty() == false) {
            int[] comment = stack.pop();
            int commentId = comment[0];
            int depth = comment[1];

            if (replyMap.containsKey(commentId)) {
                for (int replyId : replyMap.get(commentId)) {
                    stack.push(new int[]{replyId, depth+1});
                }
                continue;
            }

            if (maxDepth < depth) {
                maxDepth = depth;
            }
        }

        return maxDepth;
    }
}
