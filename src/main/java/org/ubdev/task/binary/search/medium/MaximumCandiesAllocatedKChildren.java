package org.ubdev.task.binary.search.medium;

public class MaximumCandiesAllocatedKChildren {

    public int maximumCandies(int[] candies, long k) {
        int low = 0;
        int high = Integer.MAX_VALUE - 1;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count >= k) {
                low = mid;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}
