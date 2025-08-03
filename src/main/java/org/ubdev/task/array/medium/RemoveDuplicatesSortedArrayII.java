package org.ubdev.task.array.medium;

class RemoveDuplicatesSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int left  = 1;
        int right = 1;
        int currNumCounter = 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left++] = nums[right];
                currNumCounter = 1;
            } else {
                currNumCounter++;
                if (currNumCounter <= 2) {
                    nums[left++] = nums[right];
                }
            }
            right++;
        }
        return left;
    }
}
