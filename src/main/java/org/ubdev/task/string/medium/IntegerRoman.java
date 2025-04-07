package org.ubdev.task.string.medium;

public class IntegerRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int count = num / 1000;
        sb.repeat("M", count);
        num %= 1000;
        count = num / 100;
        sb.append(getFrom(count, "C", "D", "M"));
        num %= 100;
        count = num / 10;
        sb.append(getFrom(count, "X", "L", "C"));
        num %= 10;
        count = num;
        sb.append(getFrom(count, "I", "V", "X"));
        return sb.toString();
    }

    private StringBuilder getFrom(int count, String small, String mid, String big) {
        StringBuilder sb = new StringBuilder();
        if (count <= 3) {
            sb.repeat(small, count);
        } else if (count == 4) {
            sb.append(small).append(mid);
        } else if (count == 5) {
            sb.append(mid);
        } else if (count <= 8) {
            sb.append(mid).repeat(small, count - 5);
        } else {
            sb.append(small).append(big);
        }
        return sb;
    }
}
