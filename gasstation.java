class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        int currentGas = 0;
        int startIndex = 0;
        
        for (int i = 0; i < n; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0; 
            }
        }
        return startIndex;
    }
}
