package org.ubdev.task.graph.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) { // BFS. Check cycle
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] isSafe = new boolean[n];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if (!hasCycle(graph, visited, isSafe, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean hasCycle(int[][] graph, boolean[] visited, boolean[] isSafe, int start) {
        if(visited[start])
            return !isSafe[start];
        visited[start] = true;
        for(int neighbor : graph[start]){
            if (hasCycle(graph, visited, isSafe, neighbor)) {
                return true;
            }
        }
        isSafe[start] = true;
        return false;
    }

    public List<Integer> eventualSafeNodesBFS(int[][] graph) { // BFS
        int n = graph.length;
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            int[] vertex = graph[i];
            inDegree[i] = vertex.length;
            if (vertex.length == 0)
                queue.offer(i);
            for(int neighbor : vertex) {
                adjMap.putIfAbsent(neighbor, new LinkedList<>());
                adjMap.get(neighbor).add(i);
            }
        }
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(Integer neighbor : adjMap.getOrDefault(vertex, new ArrayList<>())) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                result.add(i);
        return result;
    }
    public static void main(String[] args) {
        FindEventualSafeStates finder = new FindEventualSafeStates();
        finder.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}});
    }
}
