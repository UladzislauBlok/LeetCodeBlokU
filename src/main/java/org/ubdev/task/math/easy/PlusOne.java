package org.ubdev.task.math.easy;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else  {
                digits[i] = 0;
            }
            i--;
        }
        int[] res =  new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
