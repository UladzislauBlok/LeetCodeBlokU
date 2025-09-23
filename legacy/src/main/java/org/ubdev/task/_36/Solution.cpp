class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int cols[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int boxes[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                int box_num = i/3*3 + j/3;
                int num = c-'0';
                int mask = 1 << num;
                if ((rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (boxes[box_num] & mask) != 0) {
                    return false;
                }
                rows[i] |= mask;
                cols[j] |= mask;
                boxes[box_num] |= mask;
            }
        }
        return true;
    }
};