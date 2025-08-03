package org.ubdev.task.array.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

class ZeroArrayTransformationIII {

    public int maxRemoval(int[] nums, int[][] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        int[] preSum = new int[nums.length + 1];
        int queryIdx = 0;
        int sum = 0;
        int used = 0;
        for(int i = 0; i < nums.length; i++){
            sum += preSum[i];
            while(queryIdx < queries.length && queries[queryIdx][0] <= i){
                pq.offer(queries[queryIdx++]);
            }
            while(nums[i] > sum && !pq.isEmpty() && pq.peek()[1] >= i){
                int[] query = pq.poll();
                used++;
                preSum[query[1] + 1]--;
                sum++;
            }
            if(nums[i] > sum) {
                return -1;
            }
        }
        return queries.length - used;
    }
}
