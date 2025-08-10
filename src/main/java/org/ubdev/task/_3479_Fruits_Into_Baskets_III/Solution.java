package org.ubdev.task._3479_Fruits_Into_Baskets_III;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

import static org.ubdev.util.Topic.*;

@LeetCodeName("Fruits Into Baskets III")
@Topics({ARRAY, SEGMENT_TREE, BINARY_SEARCH})
class Solution {
    private int[] segTree;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        // Segment tree size: 4*n is safe
        segTree = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (findAndUse(fruit, 0, n - 1, 1) == -1) {
                unplaced++;
            }
        }
        return unplaced;
    }

    // Build max‐segment‐tree over baskets[low..high], at node idx
    private void build(int[] baskets, int low, int high, int idx) {
        if (low == high) {
            segTree[idx] = baskets[low];
        } else {
            int mid = low + (high - low) / 2;
            build(baskets, low, mid, 2 * idx);
            build(baskets, mid + 1, high, 2 * idx + 1);
            segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
        }
    }

    // Find leftmost position in [low..high] with segTree value ≥ fruit,
    // set it to –1, and update tree; return 1 if found, else –1
    private int findAndUse(int fruit, int low, int high, int idx) {
        if (segTree[idx] < fruit) {
            return -1;
        }
        if (low == high) {
            // Leaf: use this basket
            segTree[idx] = -1;
            return 1;
        }
        int mid = low + (high - low) / 2;
        int res;
        if (segTree[2 * idx] >= fruit) {
            res = findAndUse(fruit, low, mid, 2 * idx);
        } else {
            res = findAndUse(fruit, mid + 1, high, 2 * idx + 1);
        }
        // Update current node after child change
        segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
        return res;
    }
}
