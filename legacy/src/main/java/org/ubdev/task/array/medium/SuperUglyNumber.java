package org.ubdev.task.array.medium;

import java.util.PriorityQueue;

class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(1);
        int currentUglyNumber = 0;
        while (n-- > 0) {
            currentUglyNumber = minHeap.poll();
            while (!minHeap.isEmpty() && minHeap.peek() == currentUglyNumber) { //remove duplicates
                minHeap.poll();
            }
            for (int prime : primes) {
                if (prime <= Integer.MAX_VALUE / currentUglyNumber) {
                    minHeap.offer(prime * currentUglyNumber);
                }
                if (currentUglyNumber % prime == 0) {
                    break;
                }
            }
        }
        return currentUglyNumber;
    }
}
