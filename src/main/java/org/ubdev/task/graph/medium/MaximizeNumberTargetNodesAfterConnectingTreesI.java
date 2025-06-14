package org.ubdev.task.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaximizeNumberTargetNodesAfterConnectingTreesI {

    /**
     * Build two adjacent list. Find best connect point in tree2. Get dfs from tree1 + bast result from tree 2
     */
	public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        var g2 = build(edges2);
        int m = edges2.length + 1;
        int t = 0;
        for (int i = 0; i < m; ++i) {
            t = Math.max(t, dfs(g2, i, -1, k - 1));
        }
        var g1 = build(edges1);
        int n = edges1.length + 1;
        int[] ans = new int[n];
        Arrays.fill(ans, t);
        for (int i = 0; i < n; ++i) {
            ans[i] += dfs(g1, i, -1, k);
        }
        return ans;
    }

    /**
     * Build an adjacent list
     */
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

    /**
     * @param g - adjacent list
     * @param a - current vertex
     * @param fa - previous vertex
     * @param d - path length
     * @return Max elements within the d
     */
    private int dfs(List<Integer>[] g, int a, int fa, int d) {
        if (d < 0) {
            return 0;
        }
        int cnt = 1;
        for (int b : g[a]) {
            if (b != fa) {
                cnt += dfs(g, b, a, d - 1);
            }
        }
        return cnt;
    }
}
