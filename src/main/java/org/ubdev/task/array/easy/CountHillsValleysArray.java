package org.ubdev.task.array.easy;

class CountHillsValleysArray {

    public int countHillValley(int[] nums) {
        int n = nums.length;
        int prev = -1;
        int curr = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == curr)
                continue;
            if (prev != -1) {
                if ((prev < curr) == (num < curr))
                    count++;
            }
            prev = curr;
            curr = num;
        }
        return count;
    }
}
