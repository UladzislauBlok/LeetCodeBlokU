package org.ubdev.task.sliding.window.medium;

public class LongestNiceSubarray {

    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        for (int left = 0, right = 0; left < nums.length && right < nums.length; left++) {
            right = left + 1;
            int curr = nums[left];
            int counter = 1;
            while (right < nums.length) {
                int rNum = nums[right++];
                if ((curr & rNum) != 0)
                    break;
                curr ^= rNum;
                counter++;
                max = Math.max(max, counter);
            }
        }
        return max;
    }
}
