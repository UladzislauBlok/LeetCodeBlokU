#include <vector>

class Solution {
public:
  int maxFrequencyElements(std::vector<int> &nums) {
    int max = 0;
    int count = 0;
    int map[101];
    for (int num : nums) {
      map[num]++;
      if (map[num] > max) {
        count = 1;
        max = map[num];
      } else if (map[num] == max) {
        count++;
      }
    }
    return max * count;
  }
};
