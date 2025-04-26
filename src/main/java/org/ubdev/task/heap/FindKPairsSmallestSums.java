package org.ubdev.task.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            queue.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty() && k > 0) {
            int[] currentPair = queue.poll();

            result.add(Arrays.asList(nums1[currentPair[1]], nums2[currentPair[2]]));

            --k;

            if (currentPair[2] + 1 < nums2.length) {
                queue.offer(new int[]{nums1[currentPair[1]] + nums2[currentPair[2] + 1], currentPair[1], currentPair[2] + 1});
            }
        }
        return result;
    }
}
