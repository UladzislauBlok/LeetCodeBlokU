#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int maxFreqSum(string s) {
    vector<int> map(128);
    int maxV = 0;
    int maxC = 0;
    for (auto &c : s) {
      map[c]++;
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        maxV = std::max(maxV, map[c]);
      } else {
        maxC = std::max(maxC, map[c]);
      }
    }
    return maxV + maxC;
  }
};
