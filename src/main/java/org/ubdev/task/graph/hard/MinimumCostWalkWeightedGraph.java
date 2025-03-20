package org.ubdev.task.graph.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumCostWalkWeightedGraph {
    private static final Map<Integer, Set<Pair>> graph = new HashMap<>();

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            if (!graph.containsKey(query[i][0]) || !graph.containsKey(query[i][1])) {
                res[i] = -1;
            } else {
                res[i] = findPath(query[i][0], query[i][1]);
            }
        }

        return res;
    }

    private record Pair(int direction, int cost) {
    }
}
