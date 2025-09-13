#include <algorithm>
#include <string>

using namespace std;

class Solution {
public:
  bool doesAliceWin_my(string s) {
    for (auto &c : s) {
      switch (c) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        return true;
      }
    }
    return false;
  }

  static bool doesAliceWin(string &s) {
    // 0x104111 = 0b100000100000100010001
    return any_of(s.begin(), s.end(),
                  [](char c) { return ((0x104111 >> (c - 'a')) & 1); });
  }
};
