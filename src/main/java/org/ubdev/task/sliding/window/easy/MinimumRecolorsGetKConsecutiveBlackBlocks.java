package org.ubdev.task.sliding.window.easy;

public class MinimumRecolorsGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        char[] blocksArray = blocks.toCharArray();
        int left = 0;
        int right = left + k - 1;
        int min = 0;
        for (int i = 0; i <= right; i++) {
            if (blocksArray[i] == 'W')
                min++;
        }
        int currMin = min;
        while (right < blocksArray.length - 1) {
            right++;
            if (blocksArray[right] == 'W')
                currMin++;
            if (blocksArray[left] == 'W')
                currMin--;
            left++;
            min = Math.min(min, currMin);
        }
        return min;
    }
}
