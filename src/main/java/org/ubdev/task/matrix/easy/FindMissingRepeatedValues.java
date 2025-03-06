package org.ubdev.task.matrix.easy;

public class FindMissingRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] map = new int[rows * cols + 1];
        for (int[] row : grid) {
            for (int j = 0; j < cols; j++) {
                map[row[j]]++;
            }
        }
        int[] res = new int[2];
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0)
                res[1] = i;
            if (map[i] == 2)
                res[0] = i;
        }
        return res;
    }
}
