package org.ubdev.task.dynamic.programming.medium;

class SoupServings {
    private final double[][] memo = new double[200][200];

    // Entry method which adjusts servings (if necessary) and starts the depth-first search
    public double soupServings(int n) {
        // If n is larger than 4800, we assume probability is practically 1
        return n > 4800 ? 1.0 : dfs((n + 24) / 25, (n + 24) / 25);

    }

    // In short there are 4 cases. Check all + add memorization
    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0;
        }
        if (memo[a][b] > 0) {
            return memo[a][b];
        }
        double probability = 0.25 * (
                dfs(a - 4, b) +
                        dfs(a - 3, b - 1) +
                        dfs(a - 2, b - 2) +
                        dfs(a - 1, b - 3)
        );
        memo[a][b] = probability;
        return probability;
    }
}
