package org.ubdev.task.array.easy;

class FruitsIntoBasketsII {

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
