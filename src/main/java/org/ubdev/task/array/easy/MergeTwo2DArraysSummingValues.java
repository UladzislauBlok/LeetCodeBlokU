package org.ubdev.task.array.easy;

public class MergeTwo2DArraysSummingValues {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] map = new int[1001];
        int counter = 0;
        for (int[] ints : nums1) {
            int key = ints[0];
            int value = ints[1];
            if (map[key] == 0) {
                counter++;
            }
            map[key] += value;
        }
        for (int[] ints : nums2) {
            int key = ints[0];
            int value = ints[1];
            if (map[key] == 0) {
                counter++;
            }
            map[key] += value;
        }
        int[][] result = new int[counter][2];
        int resultIndex = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0)
                continue;
            result[resultIndex][0] = i;
            result[resultIndex][1] = map[i];
            resultIndex++;
        }
        return result;
    }
}
