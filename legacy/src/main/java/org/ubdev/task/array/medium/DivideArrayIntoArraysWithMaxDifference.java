package org.ubdev.task.array.medium;

import java.util.Arrays;

class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] res = new int[n/3][3];
        for (int i = 0; i < n / 3; i++) {
            res[i][0] = nums[i * 3];
            for(int j = 1; j < 3; j++) {
                res[i][j] = nums[i * 3 + j];
                if (res[i][j] - res[i][0] > k)
                    return new int[0][0];
            }
        }
        return res;
    }
}
