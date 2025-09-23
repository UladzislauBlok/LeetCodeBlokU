package org.ubdev.task.sliding.window.medium;

import java.util.HashSet;
import java.util.Set;

class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        boolean[] seen = new boolean[10001];
        int max = Integer.MIN_VALUE;
        int sum = 0, right = 0, left = 0;
        int n = nums.length;
        while (right < n) {
            while (seen[nums[right]]) {
                sum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            while (right < n && !seen[nums[right]]) {
                sum += nums[right];
                seen[nums[right]] = true;
                right++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maximumUniqueSubarraySet(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int sum = 0, right = 0, left = 0;
        int n = nums.length;
        while (right < n) {
            while (seen.contains(nums[right])) {
                sum -= nums[left];
                seen.remove(nums[left]);
                left++;
            }
            while (right < n && !seen.contains(nums[right])) {
                sum += nums[right];
                seen.add(nums[right]);
                right++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
