package org.ubdev.task.dynamic.programming.hard;

class FindMaximumNumberFruitsCollected {

    // Dp problem
    // Key here is that first child (started at 0,0)
    // can go only +1,+1 to reach final point withing n-1 moves
    // This will separate grid into two parts
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp = new int[n][n];
        // child1
        dp[0][0] = fruits[0][0];
        for (int i = 1; i < n-1; i++) {
            dp[i][i] = dp[i-1][i-1] + fruits[i][i];
            fruits[i][i] = -1;
        }
        int steps = 2;
        // child2
        dp[0][n-1] = fruits[0][n-1];
        for (int i = 1; i < n-1; i++) {
            dp[i][n-1] = Math.max(dp[i-1][n-1], dp[i-1][n-2]) + fruits[i][n-1];
            int j = n-2, curr = steps++;
            while (curr-- > 1) {
                if (fruits[i][j] == -1)
                    break;
                // System.out.println(i+":"+j);
                dp[i][j] = Math.max(dp[i-1][j+1], Math.max(dp[i-1][j], dp[i-1][j-1])) + fruits[i][j];
                j--;
            }
        }
        // child3
        steps = 2;
        dp[n-1][0] = fruits[n-1][0];
        for (int i = 1; i < n-1; i++) {
            dp[n-1][i] = Math.max(dp[n-1][i-1], dp[n-2][i-1]) + fruits[n-1][i];
            int j = n-2, curr = steps++;
            while (curr-- > 1) {
                // System.out.println(i+":"+j);
                if (fruits[j][i] == -1)
                    break;
                dp[j][i] = Math.max(dp[j+1][i-1], Math.max(dp[j][i-1], dp[j-1][i-1])) + fruits[j][i];
                j--;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return fruits[n-1][n-1] + dp[n-2][n-2] + dp[n-1][n-2] + dp[n-2][n-1];
    }

    public int maxCollectedFruits1(int[][] A) {
        int n = A.length;
        // Set inaccessible cells to 0
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i < j && j < n - 1 - i) {
                    A[i][j] = 0;
                }
                if (j < i && i < n - 1 - j) {
                    A[i][j] = 0;
                }
            }
        }

        // First child
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += A[i][i];
        }

        // Second child
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                A[i][j] += Math.max(A[i - 1][j - 1],
                        Math.max(A[i - 1][j], (j + 1 < n) ? A[i - 1][j + 1] : 0));
            }
        }

        // Third child
        for (int j = 1; j < n; ++j) {
            for (int i = j + 1; i < n; ++i) {
                A[i][j] += Math.max(A[i - 1][j - 1],
                        Math.max(A[i][j - 1], (i + 1 < n) ? A[i + 1][j - 1] : 0));
            }
        }

        return res + A[n - 1][n - 2] + A[n - 2][n - 1];
    }
}
