package org.ubdev.task.string.easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (true) {
            char c = 0;
            for (String str : strs) {
                if (index >= str.length()) {
                    return str;
                }
                if (c == 0) {
                    c = str.charAt(index);
                }
                if (c != str.charAt(index)) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
    }
}
