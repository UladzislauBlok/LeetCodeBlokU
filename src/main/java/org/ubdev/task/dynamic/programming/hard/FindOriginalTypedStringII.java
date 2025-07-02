package org.ubdev.task.dynamic.programming.hard;

import java.util.ArrayList;
import java.util.List;

public class FindOriginalTypedStringII {

    private static final int MOD = (int) 1e9 + 7;

    public int possibleStringCount(String word, int k) {
        List<Integer> groups = prefixSum(word);
        long totalCombinations = 1; // will multiply
        for (Integer group : groups) {
            totalCombinations *= group;
            totalCombinations %= MOD;
        }
        if (k <= groups.size())
            return (int) totalCombinations;

        // find all cases when length < k
        int[] dp = new int[k];
        dp[0] = 1; // Base case: empty string

        for (int i = 0; i < groups.size(); i++) {
            int[] newDp = new int[k];
            int windowSum = 0;
            int group = groups.get(i);
            for (int j = i; j < k; j++) {
                newDp[j] = (newDp[j] + windowSum) % MOD;
                windowSum = (windowSum + dp[j]) % MOD;
                if (j >= group)
                    windowSum = (windowSum - dp[j - group] + MOD) % MOD; // + MOD for case when winSum < curr dp
            }
            dp = newDp;
        }

        int invalidCombinations = 0;
        for (int num : dp) {
            invalidCombinations += num;
            invalidCombinations %= MOD;
        }
        return (int) (totalCombinations - invalidCombinations + MOD) % MOD;
    }

    private List<Integer> prefixSum(final String word) {
        List<Integer> groups = new ArrayList<>();
        int elems = 1; // always one elem in group
        for (int i = 1; i < word.length(); ++i)
            if (word.charAt(i) == word.charAt(i - 1)) {
                elems++;
            } else {
                groups.add(elems);
                elems = 1;
            }
        groups.add(elems);
        return groups;
    }
}
