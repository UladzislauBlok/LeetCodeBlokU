package org.ubdev.task.array.medium;

class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curGain = 0, answer = 0;

        for (int i = 0; i < gas.length ; i++){
            total += gas[i] - cost[i];
            curGain += gas[i] - cost[i];

            if (curGain < 0){
                answer = i + 1;
                curGain = 0;
            }
        }

        return total >= 0 ? answer : -1;
    }
}
