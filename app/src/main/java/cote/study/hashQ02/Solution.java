package cote.study.hashQ02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportedCountMap = new HashMap<>();
        
        int[] result = new int[id_list.length];

        Arrays.fill(result, 0);

        for(int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
        }

        for(int i = 0; i < report.length; i++) {
            String[] reports = report[i].split(" ");
            // 0 - who
            // 1 - target
            Set<String> reportSet = reportMap.get(reports[0]);
            if(reportSet.contains(reports[1]) == false) {
                reportSet.add(reports[1]);
                reportedCountMap.merge(reports[1], 1, Integer::sum);
            }
        }

        for(int i = 0; i < id_list.length; i++) {
            Set<String> reportData = reportMap.get(id_list[i]);
            int lambdaI = i;
            reportData.iterator().forEachRemaining((reported) -> {
                int reportedCount = reportedCountMap.getOrDefault(reported, 0);
                if(reportedCount >= k) {
                    result[lambdaI]++;
                }
            });
        }

        return result;
    }
}
