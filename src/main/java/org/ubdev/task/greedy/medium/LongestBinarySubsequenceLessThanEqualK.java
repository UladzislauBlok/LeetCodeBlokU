package org.ubdev.task.greedy.medium;

class LongestBinarySubsequenceLessThanEqualK {

    public int longestSubsequence(String s, int k) {
        int power = 0;
        int count = 0;
        long val = 0;
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                count++;
            } else if (power < 32) { // int is 32 bits long
                val += Math.pow(2, power); // 2 because binary string
                if (val <= k) count++;
            }
            power++;
        }
        return count;
    }
}
