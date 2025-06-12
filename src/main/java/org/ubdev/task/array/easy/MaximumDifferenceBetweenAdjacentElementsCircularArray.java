package org.ubdev.task.array.easy;

public class MaximumDifferenceBetweenAdjacentElementsCircularArray {

    public int maxAdjacentDistance(int[] nums) {
        int max = Math.abs(nums[0] - nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            max = Math.max(max, diff);
        }
        return max;
    }
}
