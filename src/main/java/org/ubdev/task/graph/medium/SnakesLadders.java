package org.ubdev.task.graph.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SnakesLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int current = queue.poll();
                if (current == n * n) {
                    return moves;
                }
                for (int k = current + 1; k <= Math.min(current + 6, n * n); k++) {
                    int boardVal = getFromBoard(n, k, board);
                    int next = k;
                    if (boardVal != -1) {
                        next = boardVal;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int getFromBoard(int n, int pos, int[][] board) {
        pos = pos - 1;
        int row = pos / n;
        boolean leftToRight = (row % 2 == 0);
        int posInRow = pos % n;
        int rowFromTheEnd = n - row - 1;
        return leftToRight ? board[rowFromTheEnd][posInRow] : board[rowFromTheEnd][n - posInRow - 1];
    }
}
