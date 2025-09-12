package cote.study.dpQ01;

import java.util.*;

public class Solution {
    private List<int[]> energyUsage = new ArrayList<>();

    public void setEnergyUsage(List<int[]> energyUsage) {
        this.energyUsage = new ArrayList<>(energyUsage);
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        
        int workbenchCnt = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < workbenchCnt - 1; i++) {
            String tmp = sc.nextLine();
            String[] splitedTmp = tmp.split(" ");
            int[] energies = Arrays.stream(splitedTmp).mapToInt(Integer::parseInt).toArray();
            energyUsage.add(energies);
        }

        int result = dp(workbenchCnt);
        System.out.println(result);
    }

    public int dp(int workbenchCnt) {
        // energyUsage[n][0] = 일반 에너지, 1칸 이동
        // energyUsage[n][1] = 특수 에너지, 2칸 이동

        int[] totalUsages = new int[workbenchCnt+1];
        int minUsage = 0;
        
        totalUsages[1] = 0;
        totalUsages[2] = energyUsage.get(0)[0];

        for(int i = 3; i <= workbenchCnt; i++) {
            int normalUsage = totalUsages[i-1] + energyUsage.get(i-2)[0];
            int specialUsage = totalUsages[i-2] + energyUsage.get(i-3)[1];

            minUsage = Math.min(specialUsage, normalUsage);
            totalUsages[i] = minUsage;
        }

        return minUsage;
    }
}
