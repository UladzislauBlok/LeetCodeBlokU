#include <cmath>
#include <algorithm>

class Solution {
public:
    int areaOfMaxDiagonalMy(vector<vector<int>>& dimensions) {
        int a = 0;
        double md = 0.0;
        for (auto& row : dimensions) {
            double d = std::sqrt(row[0]*row[0] + row[1]*row[1]);
            if (md < d) {
                md = d;
                a = row[0] * row[1];
            } else if (md == d) {
                a = std::max(a, row[0] * row[1]);
            }
        }
        return a;
    }

    int areaOfMaxDiagonal(vector<vector<int>>& dimensions) {
        auto cmp=[](vector<int>& r1, vector<int>& r2){
            const int w1=r1[0], h1=r1[1], w2=r2[0], h2=r2[1];
            return make_pair(w1*w1+h1*h1, w1*h1)<make_pair(w2*w2+h2*h2, w2*h2);
        };
        auto it=max_element(dimensions.begin(), dimensions.end(), cmp);
        return (*it)[0]*(*it)[1];
    }
};