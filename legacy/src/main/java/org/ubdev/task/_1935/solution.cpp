class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        bool bl[26];
        for (auto &c : brokenLetters) {
            bl[c-'a'] = true;
        }
        bool flag = false;
        int count = 0;
        for (auto &c : text) {
            if (c == ' ') {
                count = flag ? count : count + 1; 
                flag = false;
            } else if (!flag) {
                flag = bl[c-'a'];
            }
        }
        return flag ? count : count + 1;        
    }
};
