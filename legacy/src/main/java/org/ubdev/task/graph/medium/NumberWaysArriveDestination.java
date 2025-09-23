package org.ubdev.task.graph.medium;

import java.util.Arrays;

class NumberWaysArriveDestination {
    private static final int MODULO = (int) (Math.pow(10, 9) + 7);

    public int countPaths(int n, int[][] roads) {
        long[][] graph = new long[n][n];
        long[] distances = new long[n];
        int[] ways = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, Long.MAX_VALUE / 2);
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Long.MAX_VALUE / 2);
        }
        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        graph[0][0] = 0;
        distances[0] = 0;
        ways[0] = 1;
        for (int i = 0; i < n; ++i) {
            int current = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (current == -1 || distances[j] < distances[current])) {
                    current = j;
                }
            }
            visited[current] = true;
            for (int j = 0; j < n; ++j) {
                if (j == current) {
                    continue;
                }
                long newDistance = distances[current] + graph[current][j];
                if (distances[j] > newDistance) {
                    distances[j] = newDistance;
                    ways[j] = ways[current];
                }
                else if (distances[j] == newDistance) {
                    ways[j] = (ways[j] + ways[current]) % MODULO;
                }
            }
        }
        return ways[ways.length - 1];
    }
}
