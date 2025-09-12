package cote.study.graphQ01;

import java.util.List;

public class Solution {
    public String solution(int n, List<int[]> connections, int stationA, int stationB) {
        for(int[] connection : connections) {
            int connectionA = connection[0];
            int connectionB = connection[1];

            boolean isStationA = connectionA == stationA || connectionB == stationA;

            if(isStationA == false) {
                continue;
            }

            boolean isStationB = connectionA == stationB || connectionB == stationB;

            if(isStationB) {
                return "YES";
            }
        }

        return "NO";
    }
}
