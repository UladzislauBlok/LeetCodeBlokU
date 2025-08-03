package org.ubdev.task.array.easy;

class FindLuckyIntegerArray {

    public int findLucky(int[] nums) {
        int[] map = new int[501];
        for (int num : nums) {
            map[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (map[i] == i)
                return i;
        }
        return -1;
    }
}
