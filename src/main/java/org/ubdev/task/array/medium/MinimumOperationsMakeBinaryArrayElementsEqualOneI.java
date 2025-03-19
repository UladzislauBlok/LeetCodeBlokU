package org.ubdev.task.array.medium;

public class MinimumOperationsMakeBinaryArrayElementsEqualOneI {

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = i; j < i + 3; j++) {
                    nums[j] ^= 1;
                }
            }
        }
        for (int i = nums.length - 3; i < nums.length; i++) {
            if (nums[i] == 0)
                return -1;
        }
        return count;
    }
}
