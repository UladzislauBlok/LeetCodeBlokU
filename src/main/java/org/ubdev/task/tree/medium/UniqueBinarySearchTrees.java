package org.ubdev.task.tree.medium;

public class UniqueBinarySearchTrees {
    // num of bst on right * num of bst on left
    // for each n for each root
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // when 0 elem -> one tree
        for(int num = 1; num <= n; num++) {
            for(int root = 0; root < num; root++) {
                dp[num] += dp[root] * dp[num - root - 1];
            }
        }
        return dp[n];
    }
}
