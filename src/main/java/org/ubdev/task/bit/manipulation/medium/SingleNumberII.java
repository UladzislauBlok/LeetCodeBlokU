package org.ubdev.task.bit.manipulation.medium;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int n : nums) {
            ones = ((ones ^ n) & (~twos));
            twos = ((twos ^ n) & (~ones));
        }
        return ones;
    }

    public int singleNumberEachBit(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (final int num : nums)
                sum += num >> i & 1;
            sum %= 3;
            ans |= sum << i;
        }
        return ans;
    }
}
