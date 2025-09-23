package org.ubdev.task._837;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;


import static org.ubdev.util.Topic.*;

@LeetCodeName("Longest Harmonious Subsequence")
@Topics({MATH, DYNAMIC_PROGRAMMING, SLIDING_WINDOW, PROBABILITY})
class Solution {

    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[k + maxPts];
        double window = 0.0;
        for (int i = k; i < k + maxPts; i++) {
            if (i <= n)
                dp[i] = 1.0;
            else
                dp[i] = 0.0;
            window += dp[i];
        }
        for (int i = k - 1; i >= 0; i--) {
            dp[i] = window / maxPts;
            window += dp[i];
            window -= dp[i + maxPts];
        }
        return dp[0];
    }
}
