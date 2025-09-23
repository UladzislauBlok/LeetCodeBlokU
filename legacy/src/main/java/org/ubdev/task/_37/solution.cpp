class Solution {
private:
    vector<vector<bool>> rows;
    vector<vector<bool>> cols;
    vector<vector<bool>> boxes;
    bool res = false;
    unsigned Row[9]={0};
    unsigned Col[9]={0};
    unsigned Block[9]={0};
    vector<pair<char, char>> uncertain;
    int N;

    void backtrack(int a, int b, vector<vector<char>>& board) {
        if (a == 9)
            res = true;
        if (res)
            return;
        char c = board[a][b];
        if (c != '.') {
            if (b == 8) {
                backtrack(a+1, 0, board);
            } else {
                backtrack(a, b+1, board);
            }
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (rows[a][i] || cols[b][i] || boxes[a/3*3+b/3][i])
                continue;
            rows[a][i] = true;
            cols[b][i] = true;
            boxes[a/3*3+b/3][i] = true;
            board[a][b] = (char)('0'+i);
            if (b == 8) {
                backtrack(a+1, 0, board);
            } else {
                backtrack(a, b+1, board);
            }
            if (res)
                return;
            rows[a][i] = false;
            cols[b][i] = false;
            boxes[a/3*3+b/3][i] = false;
            board[a][b] = '.';
        }
    }

public:
    Solution() :
    rows(9, std::vector<bool>(10)),
    cols(9, std::vector<bool>(10)),
    boxes(9, std::vector<bool>(10)) {
    }

    void solveSudoku_my(vector<vector<char>>& board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rows[i][c-'0'] = true;
                    cols[j][c-'0'] = true;
                    boxes[i/3*3+j/3][c-'0'] = true;
                }
            }
        }
        backtrack(0,0, board);
    }

    void set3Cond(int i, int j,  int x){
        const int x2=1<<x;
		Row[i]|=x2;
        Col[j]|=x2;
        const int bidx=(i/3)*3 +j/3;
        Block[bidx]|=x2;
	}

    void setup(vector<vector<char>>& board) {
        uncertain.reserve(81);
        for (int i=0; i<9; i++) {
            for (int j=0; j< 9; j++) {
                char c=board[i][j];
                if ( c== '.') {
                    uncertain.emplace_back(i, j);
                }
                else {
                    set3Cond(i, j, c-'1');
                }
            }
        }
    }

    bool solve(vector<vector<char>>& board, int idx) {
        if (idx==N) return 1;
        int bestIdx=idx;// instead of idx to find bestIdx
        unsigned bestMask, minBits=9;
        for(int k=idx; k<N; k++){
            auto [i, j]=uncertain[k];
            int bidx=(i/3)*3 +j/3;
            unsigned Mask=~(Row[i]|Col[j]|Block[bidx]) & 0b111111111;
            unsigned Bz=popcount(Mask);
            if (Bz<minBits){
                minBits=Bz;// with minimal bits set
                bestIdx=k; // best idx
                bestMask=Mask;
            }
            if (minBits==1) break;
        }
        swap(uncertain[idx], uncertain[bestIdx]);// swap
        unsigned Bit=0;
        auto [i, j]=uncertain[idx];
        int bidx=(i/3)*3 +j/3;
        for (; bestMask; bestMask^=Bit) {
            Bit=bit_floor(bestMask);
            const int x=countr_zero(Bit);

            board[i][j]='1'+x;
            Row[i]|=Bit; Col[j]|=Bit; Block[bidx]|=Bit;
            if (solve(board, idx+1)) return 1;
            Row[i]^=Bit; Col[j]^=Bit; Block[bidx]^=Bit;// backtracking
            board[i][j]='.';
        }
        return 0;
    }

    void solveSudoku(vector<vector<char>>& board) {
        setup(board);
        N=uncertain.size();
        solve(board, 0);
    }
};