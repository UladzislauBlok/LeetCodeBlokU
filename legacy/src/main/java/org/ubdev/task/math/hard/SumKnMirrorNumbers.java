package org.ubdev.task.math.hard;

class SumKnMirrorNumbers {

    public long kMirror(int k, int n) {
        long sum = 0;
        for (int pb = 1; n > 0; pb *= 10) { // palindrome base
            for (long i = pb; n > 0 && i < pb * 10; i++) {
                long p = createPalindrome(i, true);
                if (isPalindrome(Long.toString(p, k).toCharArray())) {
                    sum += p;
                    n--;
                }
            }
            for (long i = pb; n > 0 && i < pb * 10; i++) {
                long p = createPalindrome(i, false);
                if (isPalindrome(Long.toString(p, k).toCharArray())) {
                    sum += p;
                    n--;
                }
            }
        }
        return sum;
    }

    private long createPalindrome(long pb, boolean odd) {
        long x = pb;
        if (odd)
            x /= 10;
        while (x > 0) {
            pb = pb * 10 + x % 10;
            x /= 10;
        }
        return pb;
    }

    private boolean isPalindrome(char[] charArray) {
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }
}
