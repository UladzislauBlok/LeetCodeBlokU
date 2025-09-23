package org.ubdev.task.hashmap.easy;

import java.util.HashSet;
import java.util.Set;

class DivideArrayIntoEqualPairs {

    public boolean divideArray(int[] nums) {
        int[] map = new int[501];
        for (int num : nums) {
            map[num]++;
        }
        for (int i : map) {
            if ((i & 1) == 1)
                return false;
        }
        return true;
    }

    public boolean divideArraySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.isEmpty();
    }
}
