package org.ubdev.task.math.easy;

class DivisibleAndNonDivisibleSumsDifference {

    public int differenceOfSums(int n, int m) {
        int divMCount = n / m;
        int num2 = divMCount * (divMCount + 1) / 2 * m;
        int totalSum = n * (n + 1) / 2;
        int num1 = totalSum - num2;
        return num1 - num2;
    }
}
