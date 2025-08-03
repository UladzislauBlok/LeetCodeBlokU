package org.ubdev.task.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> box = new HashMap<>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    row.putIfAbsent(i, new HashSet<>());
                    col.putIfAbsent(j, new HashSet<>());
                    box.putIfAbsent(i / 3 * 10 + j / 3, new HashSet<>());

                    if (!row.get(i).add(board[i][j]) || !col.get(j).add(board[i][j])
                            || !box.get(i / 3 * 10 + j / 3).add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
