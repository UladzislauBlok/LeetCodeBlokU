package org.ubdev.task.graph.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<Integer> resList = new LinkedList<>();
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        int[] degree = new int[n];
        for(int[] edge : edges) {
            adjacencyMap.putIfAbsent(edge[0], new LinkedList<>());
            adjacencyMap.putIfAbsent(edge[1], new LinkedList<>());
            adjacencyMap.get(edge[0]).add(edge[1]);
            adjacencyMap.get(edge[1]).add(edge[0]);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            if (degree[i] == 1){
                queue.offer(i);
                degree[i] = 0;
            }
        }
        while(!queue.isEmpty()) {
            resList.clear();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer vertex = queue.poll();
                resList.add(vertex);
                for(Integer neighbor : adjacencyMap.get(vertex)) {
                    if (--degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return resList;
    }
}
