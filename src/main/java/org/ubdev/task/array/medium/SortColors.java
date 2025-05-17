package org.ubdev.task.array.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for(int num : nums) {
            colors[num]++;
        }
        int idx = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < colors[i]; j++) {
                nums[idx++] = i;
            }
        }
    }
}
