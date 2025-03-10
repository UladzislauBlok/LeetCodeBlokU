package org.ubdev.task.bit.manipulation.easy;

public class AddBinary {

    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = charA.length - 1, j = charB.length - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += charA[i--] - '0';
            }
            if (j >= 0) {
                carry += charB[j--] - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}