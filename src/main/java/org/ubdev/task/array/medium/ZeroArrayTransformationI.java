package org.ubdev.task.array.medium;

public class ZeroArrayTransformationI {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] differenceArray = new int[nums.length + 1];
        for(int[] query : queries) {
            differenceArray[query[0]] += 1;
            differenceArray[query[1] + 1] -= 1;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += differenceArray[i];
            if (sum < nums[i])
                return false;
        }
        return true;
    }
}
