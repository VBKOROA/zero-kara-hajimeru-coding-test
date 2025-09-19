package cote.study.simulationQ01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final String VIRUS = "V";
    private static final String EMPTY = ".";
    private static final String FIREWALL = "#";
    private static final String SAFE = "S";
    private static final int[][] VIRUS_MOVEMENT = new int[][] {
            { 1, 0 },
            { -1, 0 },
            { 0, 1 },
            { 0, -1 }
    };
    private static final int[][] VAX_CLEAN_VIRUS_CHECK_MOVMENT = new int[][] {
        {1, 0},
        {1, -1}
    };
    private static final int[][] VAX_CLEAN_VIRUS_CLEAN_MOVMENT = new int[][] {
        {1, 0},
        {1, -1},
        {0, -1},
        {0, 0}
    };

    public String[] solution(String[] grid) {
        String[][] realGrid = new String[grid.length][];

        for (int i = 0; i < realGrid.length; i++) {
            realGrid[i] = grid[i].split("");
        }

        int[][] gridVScores = new int[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            gridVScores[i] = new int[grid[i].length()];
        }

        // 무지성 바이러스 투하

        boolean vOccured = false;

        while (true) {
            for (int y = 0; y < realGrid.length; y++) {
                for (int x = 0; x < realGrid[y].length; x++) {
                    if(processVirusSpread(realGrid, gridVScores, y, x)) {
                        vOccured = true;
                    }
                }
            }

            if (vOccured) {
                if(infectGridWithVirus(realGrid, gridVScores)) {
                    resetVScore(gridVScores);
                    vOccured = false;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        // 무지성 바이러스 포착
        List<int[]> shouldClearCoor = getShouldClearCoor(realGrid);

        // 무지성 바이러스 제거
        for (int[] coor : shouldClearCoor) {
            for(int[] movement : VAX_CLEAN_VIRUS_CLEAN_MOVMENT) {
                realGrid[coor[0]+movement[0]][coor[1]+movement[1]] = SAFE;
            }
        }

        String[] result = new String[realGrid.length];

        for (int i = 0; i < realGrid.length; i++) {
            result[i] = String.join("", realGrid[i]);
        }

        return result;
    }

    private List<int[]> getShouldClearCoor(String[][] realGrid) {
        List<int[]> shouldClearCoor = new ArrayList<>();
        for (int y = 0; y < realGrid.length - 1; y++) {
            evaluateVirusContinuityScore(realGrid, shouldClearCoor, y);
        }
        return shouldClearCoor;
    }

    private void evaluateVirusContinuityScore(String[][] realGrid, List<int[]> shouldClearCoor, int y) {
        int continuousVScore = 0;
        for (int x = 0; x < realGrid[y].length; x++) {
            if(VIRUS.equals(realGrid[y][x])) {
                continuousVScore = checkVirusClearingConditions(realGrid, shouldClearCoor, y, continuousVScore, x);
            }
        }
    }

    private int checkVirusClearingConditions(String[][] realGrid, List<int[]> shouldClearCoor, int y, int continuousVScore, int x) {
        continuousVScore++;
        if(continuousVScore == 2) {
            for(int[] movement : VAX_CLEAN_VIRUS_CHECK_MOVMENT) {
                continuousVScore = incrementVirusScore(realGrid, y, continuousVScore, x, movement);
            }
            if (continuousVScore == 4) {
                shouldClearCoor.add(new int[] {y, x});
            }
            continuousVScore = 1;
        }
        return continuousVScore;
    }

    private int incrementVirusScore(String[][] realGrid, int y, int continuousVScore, int x, int[] movement) {
        if(VIRUS.equals(realGrid[y+movement[0]][x+movement[1]])) {
            continuousVScore++;
        }
        return continuousVScore;
    }

    private boolean infectGridWithVirus(String[][] realGrid, int[][] gridVScores) {
        boolean isUpdated = false;
        for (int internalY = 0; internalY < gridVScores.length; internalY++) {
            for (int internalX = 0; internalX < gridVScores[internalY].length; internalX++) {
                if (gridVScores[internalY][internalX] == 1) {
                    realGrid[internalY][internalX] = VIRUS;
                    isUpdated = true;
                }
            }
        }
        return isUpdated;
    }

    private boolean processVirusSpread(String[][] realGrid, int[][] gridVScore, int y, int x) {
        if (VIRUS.equals(realGrid[y][x])) {
            applyVirusMovementToGrid(realGrid, gridVScore, y, x);
            return true;
        } else {
            return false;
        }
    }

    private void applyVirusMovementToGrid(String[][] realGrid, int[][] gridVScores, int y, int x) {
        for (int[] movement : VIRUS_MOVEMENT) {
            try {
                if (EMPTY.equals(realGrid[y + movement[0]][x + movement[1]])) {
                    gridVScores[y + movement[0]][x + movement[1]]++;
                }
            } catch (Exception ignored) {
                // ignored
            }
        }
    }

    private void resetVScore(int[][] gridVScores) {
        for (int i = 0; i < gridVScores.length; i++) {

            Arrays.fill(gridVScores[i], 0);
        }
    }
}
