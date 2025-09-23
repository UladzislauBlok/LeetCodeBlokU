package org.ubdev.task.graph.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class MaximizeNumberTargetNodesAfterConnectingTreesII {

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        var g2 = build(edges2);
        int m = edges2.length + 1;
        int t = 0;
        t = Math.max(t, dfs(g2, 0, -1, 0));
        t = Math.max(t, dfs(g2, g2[0].getFirst(), -1, 0));
        var g1 = build(edges1);
        int n = edges1.length + 1;
        int[] ans = new int[n];
        ans[0] = dfs(g1, 0, -1, 0) + t;
        int lookupIdx = g1[0].getFirst();
        ans[lookupIdx] = dfs(g1, lookupIdx, -1, 0) + t;
        bfs(g1, ans, n, lookupIdx);
        return ans;
    }

    private List<Integer>[] build(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        return g;
    }

    private int dfs(List<Integer>[] g, int a, int fa, int d) {
        int cnt = 0;
        if (d % 2 == 0) {
            cnt++;
        }
        for (int b : g[a]) {
            if (b != fa) {
                cnt += dfs(g, b, a, d + 1);
            }
        }
        return cnt;
    }

    private void bfs(List<Integer>[] g, int[] ans, int n, int lookupIdx) {
        int lookup = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int s = queue.size();
            for(int i = 0; i < s; i++) {
                Integer a = queue.poll();
                visited[a] = true;
                for (int b : g[a]) {
                    if (!visited[b]) {
                        queue.offer(b);
                    }
                }
                ans[a] = ans[lookup];
            }
            lookup ^= lookupIdx;
        }
    }
}
