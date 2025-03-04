package org.ubdev.task.two.pointer.easy;

public class FindIndexFirstOccurrenceString {

    public int strStr(String haystack, String needle) {
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int i = 0;
        while (i + needleChars.length <= haystackChars.length) {
            if (haystackChars[i] == needleChars[0]) {
                int j = 0;
                while (j < needle.length()) {
                    if (haystackChars[i + j] != needleChars[j]) {
                        break;
                    }
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    /**
     * The best solution for this it's just use {@link String#indexOf(String)}, but let's also solve it algorithmically
     */
    public int strStrStringMethod(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
