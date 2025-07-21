package org.ubdev.task.string.easy;

class DeleteCharactersMakeFancyString {

    // delete O(n^2)
    public String makeFancyStringDelete(String s) {
        StringBuilder sb = new StringBuilder(s);
        int offset = 0;
        int counter = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1))
                counter++;
            else
                counter = 1;
            if (counter >= 3)
                sb.deleteCharAt(i - offset++);
        }
        return sb.toString();
    }

    // append O(n)
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                count++;
            else
                count = 1;
            if (count < 3)
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
