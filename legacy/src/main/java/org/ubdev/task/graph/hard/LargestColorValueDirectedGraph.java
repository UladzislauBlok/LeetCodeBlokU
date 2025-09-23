package org.ubdev.task.graph.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LargestColorValueDirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            adjacencyMap.putIfAbsent(edge[0], new ArrayList<>());
            adjacencyMap.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                int color = colors.charAt(i) - 'a';
                dp[i][color]++;
            }
        }
        int processedCount = 0;
        int answer = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            processedCount++;
            for (int neighbor : adjacencyMap.getOrDefault(curr, new ArrayList<>())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
                int neighborColor = colors.charAt(neighbor) - 'a';
                for (int color = 0; color < 26; color++) {
                    int currentMax = dp[curr][color] + (neighborColor == color ? 1 : 0);
                    dp[neighbor][color] = Math.max(dp[neighbor][color], currentMax);
                    answer = Math.max(answer, dp[neighbor][color]);
                }
            }
        }
        return processedCount == n ? answer : -1;
    }
}
