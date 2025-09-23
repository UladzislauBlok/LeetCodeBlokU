package org.ubdev.task.backtracking.medium;

class CountNumberMaximumBitwiseORSubsets {

    // OR will never make num smaller, it's always >=
    // Find max and check every combination, if == -> count++
    // enumeration, backtracking
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums)
            max |= num;
        int[] res = new int[]{0}; // ;)
        backtrack(nums, 0, 0, max, res);
        return res[0];
    }

    private void backtrack(int[] nums, int idx, int sum, int target, int[] res) {
        if (idx == nums.length)
            return;
        for (int i = idx; i < nums.length; i++) {
            int nSum = sum | nums[i];
            if (nSum == target)
                res[0]++;
            backtrack(nums, i+1, nSum, target, res);
        }
    }
}
