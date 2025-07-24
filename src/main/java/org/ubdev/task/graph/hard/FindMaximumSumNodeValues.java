package org.ubdev.task.graph.hard;

class FindMaximumSumNodeValues {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        long count = 0;
        long minGain = Long.MAX_VALUE;
        for (int n : nums) {
            int x = n ^ k;
            sum += Math.max(x, n);
            if (x > n) count++;
            minGain = Math.min(minGain, Math.abs(n - x));
        }
        return sum - (count % 2 != 0 ? minGain : 0);
    }
}
