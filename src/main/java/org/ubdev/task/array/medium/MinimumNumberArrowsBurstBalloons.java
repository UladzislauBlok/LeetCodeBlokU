package org.ubdev.task.array.medium;

import java.util.Arrays;
import java.util.Comparator;

class MinimumNumberArrowsBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }

        return arrows;
    }
}
