package org.ubdev.task._3487;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.*;

@LeetCodeName("Maximum Unique Subarray Sum After Deletion")
@Topics({ARRAY, HASH_TABLE, GREEDY})
class Solution {

    // make sense to sum all unique positive nums
    public int maxSum(int[] nums) {
        boolean[] seen = new boolean[101]; // 1 <= nums.length <= 100
        int sum = 0;
        int max = Integer.MIN_VALUE; // for case when all nums are negative
        for (int num : nums) {
            max = Math.max(max, num);
            if (num <= 0 || seen[num])
                continue;
            sum += num;
            seen[num] = true;
        }
        return sum == 0 ? max : sum;
    }
}
