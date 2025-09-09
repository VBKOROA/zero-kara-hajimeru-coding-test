package cote.study.hashQ01;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> completionMap = new HashMap<>();

        for(String complete : completion) {
            completionMap.merge(complete, 1, Integer::sum);
        }

        String uncompletion = "";

        for(String particient : participant) {
            if(completionMap.getOrDefault(particient, 0) == 0) {
                uncompletion = particient;
                break;
            }

            completionMap.merge(particient, 1, (old, nnew) -> old - nnew);
        }

        return uncompletion;
    }
}
