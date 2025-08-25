class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) { // Like this one
        const int r=mat.size(), c=mat[0].size();
        vector<int> ans(r*c);
        bool flip=0;

        for (int d=0, idx=0; d < r+c-1; d++, flip=!flip) {
            if (!flip) {// go NE
                for (int i=min(d, r-1), j=d-i; i>=0 && j<c; i--, j++) 
                    ans[idx++]=mat[i][j];
            } 
            else {// go SW
                for (int j=min(d, c-1), i=d-j; j>=0 && i<r; i++, j--) {
                    ans[idx++]=mat[i][j];
                }
            }
        }
        return ans;
    }

    vector<int> findDiagonalOrder1(vector<vector<int>>& matrix) {
        vector<int> res;
        map<int, vector<int>> mp;

        for(int i = 0 ; i < matrix.size() ; i++)
            for(int j = 0 ; j < matrix[0].size() ; j++)
                mp[i + j].push_back(matrix[i][j]);

        for(auto i : mp) { // interesting uses of ranges
            if((i.first)%2 == 0)
                reverse(i.second.begin(), i.second.end());

            for(auto k : i.second) res.push_back(k);
        }
        return res;
    }
};

