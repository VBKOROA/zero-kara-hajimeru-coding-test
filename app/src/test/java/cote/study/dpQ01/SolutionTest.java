package cote.study.dpQ01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void 테스트_케이스를_성공한다() {
        List<int[]> energyUsage = List.of(
            new int[]{10, 100},
            new int[]{10, 100},
            new int[]{10}
        );
        
        solution.setEnergyUsage(energyUsage);

        int result = solution.dp(4);

        assertEquals(30, result);
    }    
}
