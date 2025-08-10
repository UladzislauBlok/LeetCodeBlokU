package org.ubdev.task._2016;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.ARRAY;

@LeetCodeName("Maximum Difference Between Increasing Elements")
@Topics({ARRAY})
class Solution {

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
