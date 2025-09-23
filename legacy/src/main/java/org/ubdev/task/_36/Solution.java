package org.ubdev.task._36;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.HASH_TABLE;

@LeetCodeName("Valid Sudoku")
@Topics({HASH_TABLE})
class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int box = i/3*3 + j/3;
                int num = c - '0';
                if (rows[i][num] || cols[j][num] || boxes[box][num])
                    return false;
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[box][num] = true;
            }
        }
        return true;
    }
}
