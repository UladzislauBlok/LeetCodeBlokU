package org.ubdev.task.sliding.window.medium;

public class CountSubstringsContainingEveryVowelKConsonantsII {

    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) -  atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        char[] chs = word.toCharArray();
        int right = 0;
        int left = 0;
        long count = 0;
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        int cons = 0;
        while (right < chs.length) {
            char ch = chs[right];
            if (ch == 'a') a++;
            else if (ch == 'e') e++;
            else if (ch == 'i') i++;
            else if (ch == 'o') o++;
            else if (ch == 'u') u++;
            else cons++;

            while (a != 0 && e != 0 && i != 0 && o != 0 && u != 0 && cons >= k) {
                count += chs.length - right;
                char chL = chs[left++];
                if (chL == 'a') a--;
                else if (chL == 'e') e--;
                else if (chL == 'i') i--;
                else if (chL == 'o') o--;
                else if (chL == 'u') u--;
                else cons--;
            }
            right++;
        }
        return count;
    }
}
