package org.ubdev.task.greedy.medium;

import java.util.Arrays;

class PartitionArraySuchThatMaximumDifferenceIsK {

    // simple O(n logn)
    public int partitionArrayNlogN(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int partitions = 1;
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - min > k) {
                partitions++;
                min = nums[i];
            }
        }
        return partitions;
    }

    // O(n)
    public int partitionArray(int[] nums, int k) {
        int[] buckets = new int[100001];
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            buckets[num]++;
            min = Math.min(min, num);
        }
        int partitions = 1;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == 0) {
                continue;
            }
            if (i - min > k) {
                partitions++;
                min = i;
            }
        }
        return partitions;
    }
}
