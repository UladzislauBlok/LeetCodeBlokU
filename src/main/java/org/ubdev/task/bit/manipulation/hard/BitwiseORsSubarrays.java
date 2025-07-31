package org.ubdev.task.bit.manipulation.hard;

import java.util.HashSet;
import java.util.Set;

class BitwiseORsSubarrays {

    // It can look as O(N^2), but this is also O(N*32)
    // because of arr[i] | arr[j])==arr[j]
    // It's faster as we don't allocate too many memory
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j])
                    break;
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }

    // simple one O(N*32) N * 32 bit should change
    public int subarrayBitwiseORs1(int[] arr) {
        Set<Pair> seen = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            dfs(seen, res, i, arr[i], arr);
        return res.size();
    }

    private void dfs(Set<Pair> seen, Set<Integer> res, int idx, int num, int[] nums) {
        res.add(num);
        if (idx == nums.length)
            return;
        Pair curr = new Pair(idx, num);
        if (!seen.add(curr))
            return;
        dfs(seen, res, idx + 1, num | nums[idx], nums);
    }

    private record Pair(int pos, int val) {
    }
}
