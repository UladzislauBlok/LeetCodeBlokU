package org.ubdev.task.binary.search.medium;

import java.util.Arrays;

class MinimizeMaximumDifferencePairs {

    // O(n logn)
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        // min diff
        int left = 0;
        // max diff
        int right = nums[nums.length - 1] - nums[0];
        while(left < right) {
            int mid = (right + left) / 2;
            if (pairsLessTarget(nums, mid) >= p) {
                // If num of pairs is more than or equals to p -> make diff smaller
                right = mid;
            } else {
                // If num of pairs is less than or equals to p -> remove too small diff
                left = mid + 1;
            }
        }
        // Return diff result of binary search
        return left;
    }

    // calculate nums of pair with diff less than or equals to target
    private int pairsLessTarget(int[] nums, int target) {
        int n = nums.length;
        int pairs = 0;
        int i = 1;
        while(i < n) {
            if (nums[i] - nums[i - 1] <= target) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }
        return pairs;
    }
}
