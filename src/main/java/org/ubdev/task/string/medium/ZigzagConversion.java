package org.ubdev.task.string.medium;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length()) return s;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int firstOccurrence = numRows + numRows - 2;
        int secondOccurrence = 2;
        for (int i = 0; i < chars.length; i+= firstOccurrence) {
            sb.append(chars[i]);
        }
        firstOccurrence -= 2;
        for (int i = 1; i < numRows - 1; i++) {
            int pointer = i;
            sb.append(chars[pointer]);
            while (pointer + firstOccurrence < chars.length) {
                pointer += firstOccurrence;
                sb.append(chars[pointer]);
                if (pointer + secondOccurrence >= chars.length) break;
                pointer += secondOccurrence;
                sb.append(chars[pointer]);
            }
            firstOccurrence -= 2;
            secondOccurrence += 2;
        }
        for (int i = numRows - 1; i < chars.length; i+= secondOccurrence) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
