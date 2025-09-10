package cote.study.queueQ01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> solution(String[][] records) {
        Map<String, Deque<String>> products = new HashMap<>();
        List<Integer> salesLog = new ArrayList<>();

        for (String[] record : records) {
            String productName = record[1];
            if (record[0].equals("입고")) {
                // 입고 로직
                String productDate = record[2];
                products.computeIfAbsent(productName, t -> new ArrayDeque<>()).offer(productDate);
            } else {
                // 판매 로직
                var productQueue = products.get(productName);

                if(productQueue == null || productQueue.isEmpty()) {
                    salesLog.add(-1);
                    continue;
                }

                salesLog.add(Integer.parseInt(productQueue.poll()));
            }
        }

        return salesLog;
    }
}
