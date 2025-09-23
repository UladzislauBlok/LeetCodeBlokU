package org.ubdev.task.hashmap.medium;

import java.util.HashMap;
import java.util.Map;

class FindingPairsWithCertainSum {

    private final Map<Integer, Integer> nums1;
    private final Map<Integer, Integer> nums2Count;
    private final int[] nums2;

    public FindingPairsWithCertainSum(int[] nums1, int[] nums2) {
        this.nums1 = precalculateNums(nums1);
        this.nums2Count = precalculateNums(nums2);
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        // Never NPE as we know key was there (precalculated)
        nums2Count.compute(nums2[index], (k,v) -> v - 1); // prev - 1
        nums2[index] += val;
        nums2Count.merge(nums2[index], 1, (count, ignore) -> count + 1); // new + 1
    }

    public int count(int tot) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : nums1.entrySet()) {
            int rem = tot - entry.getKey();
            if (nums2Count.containsKey(rem)) {
                res += entry.getValue() * nums2Count.get(rem); // permutation
            }
        }
        return res;
    }

    private Map<Integer, Integer> precalculateNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (count, ignore) -> count + 1);
        }
        return map;
    }
}
