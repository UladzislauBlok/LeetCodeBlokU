package org.ubdev.task.binary.search.medium;

public class HouseRobberIV {

    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        while (low < high) {
            int mid = (low + high) >> 1;
            if (checkHouses(nums, mid) < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    private int checkHouses(int[] nums, int mid) {
        int counter = 0;
        int lastRobbedHouse = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid || lastRobbedHouse + 1 == i) {
                continue;
            }
            counter++;
            lastRobbedHouse = i;
        }
        return counter;
    }
}
