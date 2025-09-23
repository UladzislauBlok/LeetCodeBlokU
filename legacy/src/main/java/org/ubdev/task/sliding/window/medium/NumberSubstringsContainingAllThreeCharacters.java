package org.ubdev.task.sliding.window.medium;

import java.util.Arrays;

class NumberSubstringsContainingAllThreeCharacters {

    public int numberOfSubstringsLookingRight(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        int count = 0;
        int[] abc = new int[3];
        while (right < s.length()) {
            while (right < s.length()) {
                abc[chs[right++] - 'a']++;
                if (abc[0] != 0 && abc[1] != 0 && abc[2] != 0) {
                    count += s.length() - right + 1;
                    break;
                }
            }
            while (abc[0] != 0 && abc[1] != 0 && abc[2] != 0) {
                abc[chs[left++] - 'a']--;
                if (abc[0] != 0 && abc[1] != 0 && abc[2] != 0)
                    count += s.length() - right + 1;
            }
        }
        return count;
    }

    public int numberOfSubstringsLookingLeft(String s) {
        char[] ch = s.toCharArray();
        int[] abc = new int[3];
        Arrays.fill(abc, -1);
        int count = 0, right = 0;
        while (right < ch.length) {
            abc[ch[right] - 'a'] = right;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, abc[i]);
            }
            count += (min + 1);
            right++;
        }
        return count;
    }
}
