package cote.study.sortQ02;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class PackageBox implements Comparable<PackageBox> {
        public int id;
        public int weight;
        // 1 - 취급주의
        // 0 - 일반
        public int type;
        public int zone;

        public static PackageBox of(int[] array) {
            PackageBox temp = new PackageBox();
            temp.id = array[0];
            temp.weight = array[1];
            temp.type = array[2];
            temp.zone = array[3];
            return temp;
        }

        @Override
        public int compareTo(PackageBox other) {
            // -1 = this가 앞으로 이동함
            // 1 = this가 뒤로 이동함
            // 1. 유형(type) 비교: 내림차순
            int typeCompare = Integer.compare(other.type, this.type);
            if (typeCompare != 0) {
                return typeCompare;
            }

            // 2. 목적지(zone) 비교: 오름차순
            int zoneCompare = Integer.compare(this.zone, other.zone);
            if (zoneCompare != 0) {
                return zoneCompare;
            }

            // 3. 무게(weight) 비교: 내림차순
            return Integer.compare(other.weight, this.weight);
        }
    }    

    public int[] solution(int[][] packages) {
        List<PackageBox> packageList = new ArrayList<>();

        for(int[] packagee : packages) {
            packageList.add(PackageBox.of(packagee));
        }

        return packageList.stream().sorted().mapToInt(p -> p.id).toArray();
    }
}
