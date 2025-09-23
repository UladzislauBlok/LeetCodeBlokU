package org.ubdev.task._2210;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.ARRAY;

@LeetCodeName("Count Hills and Valleys in an Array")
@Topics({ARRAY})
class Solution {

    public int countHillValley(int[] nums) {
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
