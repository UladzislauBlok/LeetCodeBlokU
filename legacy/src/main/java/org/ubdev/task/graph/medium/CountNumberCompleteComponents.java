package org.ubdev.task.graph.medium;

import java.util.Arrays;

class CountNumberCompleteComponents {
    private int[][] neighbors;
    private boolean isComplete;

    public int countCompleteComponents(int n, int[][] edges) {
        neighbors = new int[n][n];
        for (int[] edge : edges) {
            neighbors[edge[0]][edge[1]]++;
            neighbors[edge[0]][edge[0]] = 1;
            neighbors[edge[1]][edge[0]]++;
            neighbors[edge[1]][edge[1]] = 1;
        }
        int counter = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            isComplete = true;
            dfs(i, neighbors[i], visited);
            if (isComplete)
                counter++;
        }
        return counter;
    }

    private void dfs(int curr, int[] expected, boolean[] visited) {
        if (visited[curr])
            return;
        visited[curr] = true;
        int[] neighborArray = neighbors[curr];
        if (!Arrays.equals(neighborArray, expected))
            isComplete = false;
        for (int i = 0; i < neighborArray.length; i++) {
            if (neighborArray[i] > 0)
                dfs(i, expected, visited);
        }
    }
}
