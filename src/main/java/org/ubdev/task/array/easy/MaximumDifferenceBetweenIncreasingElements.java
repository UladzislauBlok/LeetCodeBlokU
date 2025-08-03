package org.ubdev.task.array.easy;

class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int res = -1;
        int min = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                res = Math.max(res, nums[i] - min);
            }
        }
        return res;
    }
}
