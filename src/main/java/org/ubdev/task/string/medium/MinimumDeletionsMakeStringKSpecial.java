package org.ubdev.task.string.medium;

public class MinimumDeletionsMakeStringKSpecial {

    public int minimumDeletions(String word, int k) {
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0)
                continue;
            int leftElem = map[i]; // left means left if sorted
            int maxElem = leftElem + k;
            int count = 0;
            for (int j = 0; j < 26; j++) {
                if (map[j] < leftElem)
                    count += map[j];
                else if (map[j] > maxElem) {
                    count += map[j] - maxElem;
                }
            }
            min = Math.min(min, count);
        }
        return min;
    }
}
