class Solution {
public:
    int minimumSum(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        const int INF = 1e9;

        auto rectArea = [&](int r1, int r2, int c1, int c2) {
            int minr = n, maxr = -1, minc = m, maxc = -1;
            for (int i = r1; i <= r2; ++i) {
                for (int j = c1; j <= c2; ++j) {
                    if (grid[i][j]) {
                        minr = min(minr, i);
                        maxr = max(maxr, i);
                        minc = min(minc, j);
                        maxc = max(maxc, j);
                    }
                }
            }
            if (maxr == -1) return INF; // no 1s in this subgrid
            return (maxr - minr + 1) * (maxc - minc + 1);
        };

        int ans = INF;

        // Case 1: three vertical stripes
        for (int c1 = 0; c1 < m - 2; ++c1) {
            for (int c2 = c1 + 1; c2 < m - 1; ++c2) {
                int a1 = rectArea(0, n - 1, 0, c1);
                int a2 = rectArea(0, n - 1, c1 + 1, c2);
                int a3 = rectArea(0, n - 1, c2 + 1, m - 1);
                if (a1 != INF && a2 != INF && a3 != INF)
                    ans = min(ans, a1 + a2 + a3);
            }
        }

        // Case 2: three horizontal stripes
        for (int r1 = 0; r1 < n - 2; ++r1) {
            for (int r2 = r1 + 1; r2 < n - 1; ++r2) {
                int a1 = rectArea(0, r1, 0, m - 1);
                int a2 = rectArea(r1 + 1, r2, 0, m - 1);
                int a3 = rectArea(r2 + 1, n - 1, 0, m - 1);
                if (a1 != INF && a2 != INF && a3 != INF)
                    ans = min(ans, a1 + a2 + a3);
            }
        }

        // Case 3: vertical cut + split RIGHT horizontally
        for (int c = 0; c < m - 1; ++c) {
            int left = rectArea(0, n - 1, 0, c);
            if (left == INF) continue;
            for (int r = 0; r < n - 1; ++r) {
                int a2 = rectArea(0, r, c + 1, m - 1);
                int a3 = rectArea(r + 1, n - 1, c + 1, m - 1);
                if (a2 != INF && a3 != INF)
                    ans = min(ans, left + a2 + a3);
            }
        }

        // Case 4: vertical cut + split LEFT horizontally (missing before)
        for (int c = 0; c < m - 1; ++c) {
            int right = rectArea(0, n - 1, c + 1, m - 1);
            if (right == INF) continue;
            for (int r = 0; r < n - 1; ++r) {
                int a2 = rectArea(0, r, 0, c);
                int a3 = rectArea(r + 1, n - 1, 0, c);
                if (a2 != INF && a3 != INF)
                    ans = min(ans, right + a2 + a3);
            }
        }

        // Case 5: horizontal cut + split BOTTOM vertically
        for (int r = 0; r < n - 1; ++r) {
            int top = rectArea(0, r, 0, m - 1);
            if (top == INF) continue;
            for (int c = 0; c < m - 1; ++c) {
                int a2 = rectArea(r + 1, n - 1, 0, c);
                int a3 = rectArea(r + 1, n - 1, c + 1, m - 1);
                if (a2 != INF && a3 != INF)
                    ans = min(ans, top + a2 + a3);
            }
        }

        // Case 6: horizontal cut + split TOP vertically (missing before)
        for (int r = 0; r < n - 1; ++r) {
            int bottom = rectArea(r + 1, n - 1, 0, m - 1);
            if (bottom == INF) continue;
            for (int c = 0; c < m - 1; ++c) {
                int a2 = rectArea(0, r, 0, c);
                int a3 = rectArea(0, r, c + 1, m - 1);
                if (a2 != INF && a3 != INF)
                    ans = min(ans, bottom + a2 + a3);
            }
        }

        return ans;
    }
};