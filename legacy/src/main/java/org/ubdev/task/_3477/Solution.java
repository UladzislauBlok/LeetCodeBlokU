package org.ubdev.task._3477;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.*;

@LeetCodeName("Fruits Into Baskets II")
@Topics({ARRAY, BINARY_SEARCH, SEGMENT_TREE, SIMULATION, ORDERED_SET})
class Solution {

    // 1 <= n <= 100
    // O(N^2) will do just fine :)
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int res = fruits.length;
        for (int fruit : fruits) {
            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    res--;
                    baskets[i] = -1;
                    break;
                }
            }
        }
        return res;
    }
}
