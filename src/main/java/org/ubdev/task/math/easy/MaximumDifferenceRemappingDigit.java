package org.ubdev.task.math.easy;

public class MaximumDifferenceRemappingDigit {

    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        char[] maxNumChars = numStr.toCharArray();
        char[] minNumChars = numStr.toCharArray();
        char toReplace = '*';
        for (int i = 0; i < n; i++) {
            char c = maxNumChars[i];
            if (c != '9' && toReplace == '*') {
                toReplace = c;
            }
            if (c == toReplace) {
                maxNumChars[i] = '9';
            }
        }
        toReplace = '*';
        for (int i = 0; i < n; i++) {
            char c = minNumChars[i];
            if (c != '0' && toReplace == '*') {
                toReplace = c;
            }
            if (c == toReplace) {
                minNumChars[i] = '0';
            }
        }
        int max = Integer.parseInt(new String(maxNumChars));
        int min = Integer.parseInt(new String(minNumChars));
        return max - min;
    }

    // To make max find first non-9 num and replace it with 9
    // To make min find first non-0 num and replace it with 0
}
