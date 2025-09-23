package org.ubdev.task.graph.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

class MaximumNumberPointsFromGridQueries {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int queryLength = queries.length;
        int[][] sortedQueries = new int[queryLength][2];
        for (int i = 0; i < queryLength; ++i) {
            sortedQueries[i] = new int[] { queries[i], i };
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        int[] answers = new int[queryLength];
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] { grid[0][0], 0, 0 });

        int[] directions = new int[] { -1, 0, 1, 0, -1 };
        int count = 0;

        for (int[] query : sortedQueries) {
            int queryValue = query[0];
            int queryIndex = query[1];

            while (!queue.isEmpty() && queue.peek()[0] < queryValue) {
                int[] cell = queue.poll();
                ++count;

                for (int i = 0; i < 4; ++i) {
                    int newRow = cell[1] + directions[i];
                    int newColumn = cell[2] + directions[i + 1];

                    if (newRow >= 0 && newRow < rows
                            && newColumn >= 0 && newColumn < columns
                            && !visited[newRow][newColumn]) {
                        visited[newRow][newColumn] = true;
                        queue.offer(new int[] { grid[newRow][newColumn], newRow, newColumn });
                    }
                }
            }
            answers[queryIndex] = count;
        }
        return answers;
    }
}
