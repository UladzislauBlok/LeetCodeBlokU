package org.ubdev.task.tree.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MinimumScoreAfterRemovalsTree {

    private final boolean[][] isParents = new boolean[1000][1000]; // parent -> child
    private final int[] sums = new int[1000];
    private final Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        for (int[] edge : edges) {
            adjacentMap.putIfAbsent(edge[0], new ArrayList<>());
            adjacentMap.putIfAbsent(edge[1], new ArrayList<>());
            adjacentMap.get(edge[0]).add(edge[1]);
            adjacentMap.get(edge[1]).add(edge[0]);
        }
        // let say 0 is root
        dfsParents(0, new HashSet<>());
        dfsSums(0, -1, nums);
        int total = sums[0];
        int res = Integer.MAX_VALUE;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n - 1; i++) { // start from 1 as 0 is total
            for (int j = i + 1; j < n; j++) {
                int si = sums[i];
                int sj = sums[j];
                if (isParents[i][j]) {
                    a = sj;
                    b = si ^ sj;
                    c = total ^ si;
                } else if (isParents[j][i]) {
                    a = si;
                    b = sj ^ si;
                    c = total ^ sj;
                } else {
                    a = si;
                    b = sj;
                    c = total ^ si ^ sj;
                }
                int max = Math.max(a, Math.max(b,c));
                int min = Math.min(a, Math.min(b,c));
                res = Math.min(res, max - min);
            }
        }
        return res;
    }


    private void dfsParents(int start, Set<Integer> parents) {
        for (int par : parents)
            isParents[par][start] = true;

        parents.add(start);
        for (int child : adjacentMap.get(start)) {
            if (parents.contains(child))
                continue;
            dfsParents(child, parents);
        }
        parents.remove(start);
    }

    private int dfsSums(int start, int parent, int[] nums) {
        int curr = nums[start];
        for (int child : adjacentMap.get(start)) {
            if (child == parent)
                continue;
            curr ^= dfsSums(child, start, nums);
        }
        sums[start] = curr;
        return curr;
    }
}
