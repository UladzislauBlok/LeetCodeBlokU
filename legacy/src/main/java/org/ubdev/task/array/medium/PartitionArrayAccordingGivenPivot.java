package org.ubdev.task.array.medium;

class PartitionArrayAccordingGivenPivot {

    public int[] pivotArray(int[] nums, int pivot) {
        int[] leftPartition = new int[nums.length];
        int[] rightPartition = new int[nums.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int pivotCount = 0;
        for (int num : nums) {
            if (pivot == num) {
                pivotCount++;
            } else if (pivot > num) {
                leftPartition[leftIndex++] = num;
            } else {
                rightPartition[rightIndex++] = num;
            }
        }
        int[] res = new int[nums.length];
        int resIndex = 0;
        for (int i = 0; i < leftIndex; i++) {
            res[resIndex++] = leftPartition[i];
        }
        for (int i = 0; i < pivotCount; i++) {
            res[resIndex++] = pivot;
        }
        for (int i = 0; i < rightIndex; i++) {
            res[resIndex++] = rightPartition[i];
        }
        return res;
    }
}
