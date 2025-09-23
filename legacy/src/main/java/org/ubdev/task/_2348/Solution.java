package org.ubdev.task._2348;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.*;

@LeetCodeName("Number of Zero-Filled Subarrays")
@Topics({MATH, ARRAY})
class Solution {

    // Key here is that each new elem in subarray
    // adds us the same nums of arrays is his index
    // e.g.
    // 0, 0, 0
    // 0 - 0 = 1
    // 0, 0 - 0 .. 0, 0 .. 0 = 3
    // 0, 0, 0 - 0 .. 0, 0 .. 0 .. 0, 0, 0 .. 0, 0 .. 0 = 6
    // 1 + 2 + 3 = 6
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int prev = 0;
        for (int num :  nums) {
            if (num != 0) {
                prev = 0;
                continue;
            }
            prev++;
            count += prev;
        }
        return count;
    }
}
