package org.ubdev.task.sliding.window.medium;

import java.util.HashMap;
import java.util.Map;

class FruitIntoBaskets {

    // Going through array with right border
    // if we see new num, which is 3th
    // -> move left border until we remove all occurrence of one of nums
    // Sliding window + hash table
    // O(N)
    public int totalFruitMap(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < n) {
            map.merge(nums[right++], 1, Integer::sum);
            while (map.size() > 2) {
                map.compute(nums[left++], (k, v) -> (v == 1) ? null : v-1);
            }
            max = Math.max(max, right-left);
        };
        return max;
    }

    public int totalFruit(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int countN = 0;
        int[] map = new int[100001];
        int left = 0, right = 0;
        while (right < n) {
            if (map[nums[right]] == 0)
                countN++;
            map[nums[right++]]++;
            while (countN > 2) {
                if (map[nums[left]] == 1)
                    countN--;
                map[nums[left++]]--;
            }
            max = Math.max(max, right-left);
        };
        return max;
    }
}
