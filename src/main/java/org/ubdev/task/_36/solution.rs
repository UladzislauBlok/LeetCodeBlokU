impl Solution {

    pub fn is_valid_sudoku(board: Vec<Vec<char>>) -> bool {
        let mut rows = [0; 9];
        let mut cols = [0; 9];
        let mut boxes = [0; 9];
        for (i, row) in board.iter().enumerate() {
            for (j, &elem) in row.iter().enumerate() {
                if (elem == '.') {
                    continue;
                }
                let box_num = i/3*3 + j/3;
                let num = elem as usize - '0' as usize;
                let mask = 1 << num;
                if (rows[i] & mask != 0 || cols[j] & mask != 0 || boxes[box_num] & mask != 0) {
                    return false;
                }
                rows[i] |= mask;
                cols[j] |= mask;
                boxes[box_num] |= mask;
            }
        }
        true
    }
}