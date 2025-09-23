package org.ubdev.task.array.medium;

import java.util.Arrays;

class NumberSubsequencesThatSatisfyGivenSumCondition {

    private static final int MOD = (int)1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] powersOfTwoMod = new int[n + 1];
        powersOfTwoMod[0] = 1;
        for (int i = 1; i <= n; ++i) {
            powersOfTwoMod[i] = (powersOfTwoMod[i - 1] * 2) % MOD;
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > target / 2) {
                break;
            }
            int j = binarySearch(nums, target - nums[i], i + 1) - 1;
            count = (count + powersOfTwoMod[j - i]) % MOD;
        }
        return count;
    }

    private int binarySearch(int[] nums, int x, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
