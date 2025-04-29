package org.ubdev.task.array.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // edge cases
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> list = new ArrayList<>();
        int i = 0;

        // before overlap
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        // overlap
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        // after overlap
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }

        return list.toArray(new int[][] {});
    }
}
