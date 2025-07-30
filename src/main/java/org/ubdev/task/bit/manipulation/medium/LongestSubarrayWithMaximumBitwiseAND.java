package org.ubdev.task.bit.manipulation.medium;

class LongestSubarrayWithMaximumBitwiseAND {

    // AND nevet makes num bigger, it's the same in best case
    // Find biggest num -> find max subarray of biggest num
    public int longestSubarray1(int[] nums) {
        int max = 0, count = 0, res = 0, prev = -1;
        for (int num : nums) {
            if (num == prev) {
                count++;
            } else {
                count = 1;
            }
            if (max == num) {
                res = Math.max(res, count);
            } else if (max < num) {
                max = num;
                res = count;
            }
            prev = num;
        }
        return res;
    }

    public int longestSubarray(int[] nums) {
        int max = 0, longest = 0, cur = 0;
        for (int num : nums) {
            if  (num > max) {
                max = num;
                longest = cur = 0;
            }
            cur = num == max ? ++cur : 0;
            longest = Math.max(longest, cur);
        }
        return longest;
    }
}
