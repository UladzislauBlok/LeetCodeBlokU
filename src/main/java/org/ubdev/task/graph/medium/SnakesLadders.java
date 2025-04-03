package org.ubdev.task.graph.medium;

import java.util.Arrays;

public class SnakesLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] distances = new int[n * 2];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int pointer = 0;
    }

    private int getBoardPosition(int n, int pos) {
        int row = pos / n;
        boolean leftToRight = (row % 2 == 0);
        int posInRow = pos % n;
        return leftToRight ? posInRow - 1 : n - posInRow;
    }
}
