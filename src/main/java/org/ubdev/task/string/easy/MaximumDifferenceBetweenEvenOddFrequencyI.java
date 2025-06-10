package org.ubdev.task.string.easy;

class MaximumDifferenceBetweenEvenOddFrequencyI {

    public int maxDifference(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : map) {
            if (n % 2 == 0 && n < min && n != 0)
                min = n;
            if (n % 2 == 1 && n > max)
                max = n;
        }
        return max - min;
    }
}
