package org.ubdev.task.binary.search.medium;

class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                high = mid;
            } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
