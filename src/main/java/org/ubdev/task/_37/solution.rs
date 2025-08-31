impl Solution {

    //https://leetcode.com/problems/sudoku-solver/solutions/3448755/beats-100-3-u128-bitfields-bit-manipulation-least-amount-of-memory-space
    // Not my but looks really good
    pub fn solve_sudoku(grid: &mut Vec<Vec<char>>) {
        // These are the bit fields that keep track of the numbers
        // placed in each row, column, and box of the grid
        let mut row: u128 = 0;
        let mut col: u128 = 0;
        let mut boxes: u128 = 0;

        for r in 0..9 {
            for c in 0..9 {
                if grid[r][c] != '.' {
                    // This is calculated by left-shifting the binary value of 1
                    // by a value between 0 and 8, depending on the digit in the cell
                    let key = 1 << (grid[r][c] as usize - '1' as usize);

                    // `key` is then used to update the corresponding bit in the bit fields
                    row |= key << (r * 9);
                    col |= key << (c * 9);
                    boxes |= key << ((r / 3 * 3 + c / 3) * 9);
                }
            }
        }

        // Call the solving method recursively
        Self::solve(grid, &mut row, &mut col, &mut boxes, 0);
    }

    fn solve(
        grid: &mut Vec<Vec<char>>,
        row: &mut u128,
        col: &mut u128,
        boxes: &mut u128,
        i: usize,
    ) -> bool {
        // If reached the end
        if i == 81 {
            return true;
        }

        // Since we have a total sum, i, we use it to get the
        // row, column, and later on, the box

        // Get the index of the row and column
        let (r, c) = (i / 9, i % 9);

        // If the cell is not empty then move to the next cell
        if grid[r][c] != '.' {
            return Self::solve(grid, row, col, boxes, i + 1);
        }

        // Box index
        let b = (r / 3) * 3 + (c / 3);

        /* `mask` is a bit mask that represents the numbers that are already present
        We shift to the right to align each bits with the corresponding row, column, and box */
        let mask = (*row >> (r * 9)) | (*col >> (c * 9)) | (*boxes >> (b * 9));

        // We loop through each possible number
        for x in 0..9 {
            /* Using xmask we check to make sure that the bit has not been set
            in the row, column, or box.

            If it equals 0 then we know that we can start trying to solve for that specific cell */
            let xmask = 1 << x;
            if mask & xmask != 0 {
                continue;
            }

            // Using the same concept from setting up row, col, and boxes we update the xth bit so we can begin to test
            // We update the bit at the current x value using xmask
            *row |= xmask << (r * 9);
            *col |= xmask << (c * 9);
            *boxes |= xmask << (b * 9);

            // Since the loop is 0-8 then we do x+1
            grid[r][c] = std::char::from_digit(x + 1, 10).unwrap();

            // Recursively call itself with the next cell to check if the value works
            if Self::solve(grid, row, col, boxes, i + 1) {
                return true;
            }

            // If the value did not work then we undo the changes we made to the xth bit
            *row ^= xmask << (r * 9);
            *col ^= xmask << (c * 9);
            *boxes ^= xmask << (b * 9);
            grid[r][c] = '.';
        }
        false
    }
}
