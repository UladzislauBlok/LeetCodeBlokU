package org.ubdev.task.array.medium;

class AlternatingGroupsII {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] fullCycle =  new int[colors.length + k - 1];
        System.arraycopy(colors, 0, fullCycle, 0, colors.length);
        System.arraycopy(colors, 0, fullCycle, colors.length, k - 1);
        int right = 0;
        int left = 0;
        int count = 0;
        while (right < fullCycle.length - 1) {
            right++;
            if (fullCycle[right] == fullCycle[right - 1]) {
                left = right;
                continue;
            }
            if (right - left == k - 1) {
                count++;
                left++;
            }
        }
        return count;
    }
}
