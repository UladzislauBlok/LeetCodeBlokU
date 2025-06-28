package org.ubdev.task.array.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FindSubsequenceLengthKWithLargestSum {

    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int num = pq.poll();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        int idx = 0;
        // System.out.println(Arrays.toString(nums));
        // System.out.println(map.toString());
        for (int num : nums) {
            if (map.getOrDefault(num, 0) != 0) {
                res[idx++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return res;
    }
}
