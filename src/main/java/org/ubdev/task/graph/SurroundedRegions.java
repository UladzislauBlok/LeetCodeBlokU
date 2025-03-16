package org.ubdev.task.graph;

public class SurroundedRegions {


    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            search(board, visited, 0, i);
            search(board, visited, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            search(board, visited, i, 0);
            search(board, visited, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void search(char[][] board, boolean[][] visited, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1)
            return;
        if (board[x][y] != 'O')
            return;
        if (visited[x][y])
            return;
        visited[x][y] = true;
        search(board, visited, x + 1, y);
        search(board, visited, x, y - 1);
        search(board, visited, x, y + 1);
        search(board, visited, x - 1, y);
    }
}
