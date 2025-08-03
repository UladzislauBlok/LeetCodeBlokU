package org.ubdev.task.math.easy;

class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int remainder = x;
        int possiblePalindrome = 0;
        while (remainder > 0) {
            possiblePalindrome *= 10;
            possiblePalindrome += remainder % 10;
            remainder = remainder / 10;
        }
        return possiblePalindrome == x;
    }
}
