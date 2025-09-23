package org.ubdev.task._3423;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.ARRAY;

@LeetCodeName("Maximum Difference Between Adjacent Elements in a Circular Array")
@Topics({ARRAY})
class Solution {

    public int maxAdjacentDistance(int[] nums) {
        int max = Math.abs(nums[0] - nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            max = Math.max(max, diff);
        }
        return max;
    }
}
