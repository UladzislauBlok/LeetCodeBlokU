package org.ubdev.task.two.pointer.medium;

public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int rightIndex = numbers.length - 1;
        int leftIndex = 0;
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }
            if (sum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return new int[]{-1, -1};
    }
}
