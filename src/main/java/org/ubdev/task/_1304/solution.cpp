#include <vector>

class Solution {
public:

    std::vector<int> sumZero(int n) {
        std::vector<int> res;
        for (int i = 1; i <= n/2; i++) {
            res.push_back(i);
            res.push_back(i*-1);
        }
        if ((n&1) == 1)
            res.push_back(0);
        return res;        
    }
};
