#include <vector>

class Solution {
public:
  std::vector<int> getNoZeroIntegers(int n) {
    int a = 1;
    while (true) {
      int b = n - a;
      if (!hasZero(a) && !hasZero(b))
        break;
      a++;
    }
    return std::vector{a, n - a};
  }

private:
  bool hasZero(int n) {
    while (n > 0) {
      if (n % 10 == 0)
        return true;
      n /= 10;
    }
    return false;
  }
};
