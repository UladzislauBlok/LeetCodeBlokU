package org.ubdev.task.binary.search.medium;

class MinimumTimeRepairCars {

    public long repairCars(int[] ranks, int cars) {
        long low = 0;
        long high = (long) ranks[0] * cars * cars;
        while (low < high) {
            long mid = (low + high) >> 1;
            if (possibleRepairs(ranks, mid) >= cars) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long possibleRepairs(int[] ranks, long time) {
        long sum = 0;
        for (int rank : ranks) {
            sum += (int) Math.sqrt(time / rank);
        }
        return sum;
    }
}
