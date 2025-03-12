package org.ubdev.task.array.easy;

public class MaximumCountPositiveIntegerNegativeInteger {

    public int maximumCount(int[] nums) {
        int positive = 0, negative = 0;
        for (int i : nums) {
            if (i < 0) {
                negative++;
            }  else if (i > 0) {
                positive++;
            }
        }
        return Math.max(positive, negative);
    }
}
