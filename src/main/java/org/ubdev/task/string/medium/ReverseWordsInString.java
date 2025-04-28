package org.ubdev.task.string.medium;

public class ReverseWordsInString {

    public String reverseWords(String str) {
        char[] chars = str.toCharArray();
        char[] reversedChars = new char[chars.length];
        boolean isPrevWord = false;
        int i = chars.length - 1;
        int resPointer = 0;
        while (i >= 0) {
            if (isPrevWord && chars[i] == ' ') {
                reversedChars[resPointer++] = chars[i--];
                isPrevWord = false;
            } else if (chars[i] != ' ') {
                int j = i;
                while (j >= 0 && chars[j] != ' ') {
                    j--;
                }
                int k = j + 1;
                while (k <= i) {
                    reversedChars[resPointer++] = chars[k++];
                }
                isPrevWord = true;
                i = j;
            } else {
                i--;
            }
        }
        return new String(reversedChars).trim();
    }

    public String reverseWordsEasy(String str) {
        str = str.trim();
        String[] strs = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
