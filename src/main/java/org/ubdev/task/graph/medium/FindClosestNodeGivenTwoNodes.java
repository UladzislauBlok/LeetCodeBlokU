package org.ubdev.task.graph.medium;

import java.util.Arrays;

public class FindClosestNodeGivenTwoNodes {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] ds1 = new int[n];
        Arrays.fill(ds1, -1);
        int[] ds2 = new int[n];
        Arrays.fill(ds2, -1);
        int d = 0;
        while (node1 != -1 && ds1[node1] == -1) {
            ds1[node1] = d++;
            node1 = edges[node1];
        }
        d = 0;
        while (node2 != -1 && ds2[node2] == -1) {
            ds2[node2] = d++;
            node2 = edges[node2];
        }
        int md = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (ds1[i] != -1 && ds2[i] != -1) {
                d = Math.max(ds1[i], ds2[i]);
                if (d < md) {
                    md = d;
                    ind = i;
                }
            }
        }
        return ind;
    }
}
