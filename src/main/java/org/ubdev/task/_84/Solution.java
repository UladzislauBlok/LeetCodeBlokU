package org.ubdev.task._84;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.ubdev.util.Topic.*;

@LeetCodeName("Largest Rectangle in Histogram")
@Topics({ARRAY, STACK})
class Solution {

    public int largestRectangleArea(int[] histogram) {
        int max = Integer.MIN_VALUE, n = histogram.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i])
                right[stack.pop()] = i;
            if (!stack.isEmpty())
                left[i] = stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, histogram[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}