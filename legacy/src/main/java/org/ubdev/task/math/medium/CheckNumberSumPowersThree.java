package org.ubdev.task.math.medium;

class CheckNumberSumPowersThree {

    /**
     * To solve it we need to convert it to base 3 system (which has only 3 nums: 0,1,2), and check is there any occurrences of 2.
     * <p>Let's have some example with two cases:
     * <p>1) 91 - true. Divide it by 3 to convert into base 3 system
     * <p>91 / 3 - rest 1
     * <p>30 / 3 - rest 0
     * <p>10 / 3 - rest 1
     * <p>3 / 3 - rest 0
     * <p>1 / 3 - rest 1
     * <p>0
     * <p>let's write result number up -> down == left -> right
     * <p>10101 = 81 + 9 + 1
     * <p>---
     * <p>2) 21 - false.
     * <p>21 / 3 - rest 0
     * <p>7 / 3 - rest 1
     * <p>2 / 3 - rest 2
     * <p>0
     * <p>210 = 9 + 9 + 3
     * <p>There we have two occurrences of 9, so we should return false;
     */
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 > 1) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
