package org.ubdev.task.dynamic.programming.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLength = 1;
        int maxIdx = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (groups[i] != groups[j] && dp[i] < dp[j] + 1 && diff(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }

        List<String> result = new LinkedList<>();
        int i = maxIdx;
        while(i >= 0) {
            result.addFirst(words[i]);
            i = prev[i];
        }
        return result;
    }

    private boolean diff(String a, String b) {
        if(a.length() != b.length())
            return false;
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}
