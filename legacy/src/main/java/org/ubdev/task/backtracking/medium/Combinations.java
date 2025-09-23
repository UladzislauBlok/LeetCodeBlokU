package org.ubdev.task.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int n, int k, int start, List<Integer> currList, List<List<Integer>> result) {
        if (currList.size() == k) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i <= n; i++) {
            currList.add(i);
            backtracking(n, k, i + 1, currList, result);
            currList.removeLast();
        }
    }
}
