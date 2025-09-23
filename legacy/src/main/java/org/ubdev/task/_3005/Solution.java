package org.ubdev.task._3005;

import static org.ubdev.util.Topic.*;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

@LeetCodeName("Count Elements With Maximum Frequency")
@Topics({ARRAY, HASH_TABLE})
class Solution {

    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        int count = 0;
        int[] map = new int[101];
        for (int num : nums) {
            map[num]++;
            if (map[num] > max) {
                count = 1;
                max = map[num];
            } else if (map[num] == max) {
                count++;
            }
        }
        return max * count;
    }
}
