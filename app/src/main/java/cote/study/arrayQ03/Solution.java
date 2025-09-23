package cote.study.arrayQ03;

import java.util.Arrays;

public class Solution {
    public int solution(int length, int[][] sensors) {
        int[] traffics = new int[length];

        for(int[] sensor : sensors) {

            // sensor[0] = 시작 위치
            // sensor[1] = 속도
            int position = sensor[0];
            int speed = sensor[1];
            while ( length > position && position >= 0 ) {
                traffics[position]++;
                position += speed;
            }
        }

        return Arrays.stream(traffics).max().getAsInt();
    }
}
