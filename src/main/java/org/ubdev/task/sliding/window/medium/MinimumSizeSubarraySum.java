package org.ubdev.task.sliding.window.medium;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (right < nums.length || sum > target) {
            while (right < nums.length && sum < target) {
                sum += nums[right++];
            }
            while (left < right && sum >= target) {
                result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result ==  Integer.MAX_VALUE ? 0 : result;
    }
}
