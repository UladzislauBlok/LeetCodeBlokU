package org.ubdev.task.tree.medium;

import java.util.ArrayList;
import java.util.List;

class LexicographicalNumbers {

    // dfs
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= Math.min(9, n); i++) {
            res.add(i);
            if (i * 10 <= n)
                lexicalOrder(i * 10, n, res);
        }
        return res;
    }

    private void lexicalOrder(int b, int n, List<Integer> res) {
        for(int i = 0; i <= 9; i++) {
            if (b + i <= n)
                res.add(b + i);
            if ((b + i) * 10 <= n)
                lexicalOrder((b + i) * 10, n, res);
        }
    }
}
