package org.ubdev.task.two.pointer.easy;

class ValidPalindrome {

    /**
     * Replace all non-alphanumeric characters with ASCii table null, and then check is array str a palindrome
     */
    public boolean isPalindrome(String input) {
        char[] str = input.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= 65 && str[i] <= 90) {
                str[i] += 32;
            }
            if (!(str[i] >= 97 && str[i] <= 122) && !(str[i] >= 48 && str[i] <= 57)) {
                str[i] = 0;
            }
        }
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            while (left < str.length && str[left] == 0) {
                left++;
            }
            if (left >= str.length) {
                return true;
            }
            while (right >= 0 && str[right] == 0) {
                right--;
            }
            if (right < 0) {
                return true;
            }
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
