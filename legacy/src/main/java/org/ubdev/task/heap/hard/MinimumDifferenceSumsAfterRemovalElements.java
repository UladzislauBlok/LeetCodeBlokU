package org.ubdev.task.heap.hard;

import java.util.PriorityQueue;

class MinimumDifferenceSumsAfterRemovalElements {

    /*
    try to remove biggest possible from left side up to length - n
    try to remove smallest possible from right side up to n
    There is 3 parts:
    left, mid, right
    Check left
    Check right
    Combine mid
    Check every 'connect point' in mid
    */

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long[] lSum = new long[n + 1]; // left -> end of mid;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a); // Max heap
        // left
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pq.add(nums[i]);
        }
        lSum[0] = sum; // no removal from left
        //mid
        for (int i = n; i < n*2; i++) {
            sum += nums[i];
            pq.add(nums[i]);
            sum -= pq.poll();
            lSum[i-n+1] = sum;
        }
        //right
        sum = 0;
        pq = new PriorityQueue<>(); // Min heap
        long[] rSum = new long[n + 1]; // right -> begin of mid;
        // right
        for (int i = n*3-1; i >= n*2; i--) {
            sum += nums[i];
            pq.add(nums[i]);
        }
        rSum[n] = sum; // no removal from right
        //mid
        for (int i = n*2-1; i >= n; i--) {
            sum += nums[i];
            pq.add(nums[i]);
            sum -= pq.poll();
            rSum[i-n] = sum;
        }
        // System.out.println(Arrays.toString(lSum));
        // System.out.println(Arrays.toString(rSum));
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n+1; i++) {
            min = Math.min(min, lSum[i] - rSum[i]);
        }
        return min;
    }
}
