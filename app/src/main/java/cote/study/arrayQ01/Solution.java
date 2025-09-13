package cote.study.arrayQ01;

public class Solution {
    private int[][] frame;

    public int[][] solution(int[][] frame, int[][] rotations) {
        this.frame = frame;

        for (int[] rotation : rotations) {
            int startCoorY = rotation[0];
            int startCoorX = rotation[1];
            int areaWidth = rotation[2];

            reverse(startCoorX, startCoorY, areaWidth);

            switch (rotation[3]) {
                case 1:
                    // 90도 회전 명령
                    rotateClockwise(startCoorX, startCoorY, areaWidth);
                    break;

                default:
                    rotateCounterClockwise(startCoorX, startCoorY, areaWidth);
                    break;
            }
        }

        return frame;
    }

    private void reverse(int startCoorX, int startCoorY, int areaWidth) {
        for (int y = 0; y < areaWidth / 2; y++) {
            for (int x = 0; x < areaWidth; x++) {
                int targetY = areaWidth - y - 1;
                int temp = frame[y + startCoorY][x + startCoorX];
                frame[y + startCoorY][x + startCoorX] = frame[targetY + startCoorY][x + startCoorX];
                frame[targetY + startCoorY][x + startCoorX] = temp;
            }
        }
    }

    private void rotateClockwise(int startCoorX, int startCoorY, int areaWidth) {
        for (int y = 0; y < areaWidth; y++) {
            for (int x = 0; x < y; x++) {
                int temp = frame[y + startCoorY][x + startCoorX];
                frame[y + startCoorY][x + startCoorX] = frame[x + startCoorX][y + startCoorY];
                frame[x + startCoorX][y + startCoorY] = temp;
            }
        }
    }

    private void rotateCounterClockwise(int startCoorX, int startCoorY, int areaWidth) {
        for (int y = 0; y < areaWidth; y++) {
            for (int x = 0; x < areaWidth - y - 1; x++) {
                int targetY = startCoorY + areaWidth - x - 1;
                int targetX = startCoorX + areaWidth - y - 1;
                int temp = frame[y + startCoorY][x + startCoorX];
                frame[y + startCoorY][x + startCoorX] = frame[targetY][targetX];
                frame[targetY][targetX] = temp;
            }
        }
    }
}
