package org.ubdev.task.sliding.window.hard;

import java.util.HashMap;
import java.util.Map;

class MaximumFruitsHarvestedAfterMostKSteps {

    // Max we can go left or right up to k
    // Going to two sides: going to first one by n steps,
    // and then to second by k - 2*n
    public int maxTotalFruits1(int[][] fruits, int startPos, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] fruit : fruits)
            map.put(fruit[0], fruit[1]);
        int max = map.getOrDefault(startPos, 0); // always earn what's on the start
        int sum = 0;
        int left = startPos-k/2;
        int right = 2*left+k-startPos;
        for (int i = left; i <= right; i++) { // left to right
            sum += map.getOrDefault(i, 0);
        }
        max = Math.max(max, sum);
        // System.out.println(left+":"+right+"_"+sum);
        while (left < startPos) {
            sum -= map.getOrDefault(left++, 0);
            sum += map.getOrDefault(++right, 0);
            sum += map.getOrDefault(++right, 0);
            // System.out.println(left+":"+right+"_"+sum);
            max = Math.max(max, sum);
        }
        sum = 0;
        right = startPos+k/2;
        left = 2*right-k-startPos;
        for (int i = right; i >= left; i--) { // right to left
            sum += map.getOrDefault(i, 0);
        }
        max = Math.max(max, sum);
        // System.out.println(right+":"+left+"_"+sum);
        while (right > startPos) {
            sum -= map.getOrDefault(right--, 0);
            sum += map.getOrDefault(--left, 0);
            sum += map.getOrDefault(--left, 0);
            // System.out.println(right+":"+left+"_"+sum);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, sum = 0, max = 0;
        for (int right = 0; right < fruits.length; right++) {
            sum += fruits[right][1];
            while (left <= right && minSteps(fruits[left][0], fruits[right][0], startPos) > k) {
                sum -= fruits[left][1];
                left++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private int minSteps(int left, int right, int start) {
        // Two paths: left first or right first
        int goLeft = Math.abs(start - left) + (right - left);
        int goRight = Math.abs(start - right) + (right - left);
        return Math.min(goLeft, goRight);
    }
}
