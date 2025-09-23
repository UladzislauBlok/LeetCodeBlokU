package org.ubdev.task.tree.medium;

import org.ubdev.domain.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BSTIterator {
    private final Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        iterator = buildList(root).iterator();
    }

    private List<Integer> buildList(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(values, root);
        return values;
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void dfs(List<Integer> values, TreeNode root) {
        if (root == null)
            return;
        dfs(values, root.left);
        values.add(root.val);
        dfs(values, root.right);
    }
}
