package org.ubdev.task.greedy.medium;

public class MaxDifferenceYouCanGetFromChangingInteger {

    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        if (n == 1)
            return 8; // 9 - 1
        char[] maxNumChars = numStr.toCharArray();
        char[] minNumChars = numStr.toCharArray();
        char toReplace = '*';
        for (int i = 0; i < n; i++) { // replace first non-9 with 9 to get max
            char c = maxNumChars[i];
            if (c != '9' && toReplace == '*') {
                toReplace = c;
            }
            if (c == toReplace) {
                maxNumChars[i] = '9';
            }
        }
        toReplace = '*';
        int i;
        char replacer;
        if (minNumChars[0] == '1') {
            i = 1; // start with second one, so there is no leading zeros
            replacer = '0';
            while (i < n && (minNumChars[i] == '1' || minNumChars[i] == '0')) {
                i++; // find first non-one
            }
            if (i < n) {
                toReplace = minNumChars[i];
            }
        } else {
            i = 0; // replace first with one
            replacer = '1';
            toReplace = minNumChars[0];
        }
        while(i < n) {
            if (minNumChars[i] == toReplace) {
                minNumChars[i] = replacer;
            }
            i++;
        }
        int max = Integer.parseInt(new String(maxNumChars));
        int min = Integer.parseInt(new String(minNumChars));
        return max - min;
    }
}
