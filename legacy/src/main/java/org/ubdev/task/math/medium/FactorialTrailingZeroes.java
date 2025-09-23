package org.ubdev.task.math.medium;

class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int counter = 0;
        while (n > 0) {
            n = n / 5;
            counter += n;
        }
        return counter;
    }
}
