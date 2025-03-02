package org.ubdev.task.tree.easy;

import org.ubdev.domain.TreeNode;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lH = getLeftHeight(root);
        int rH = getRightHeight(root);

        if (rH == lH)
            return ((2 << lH) - 1);

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode root) {
        int leftHeight = 0;
        while (root.left != null) {
            root = root.left;
            leftHeight++;
        }
        return leftHeight;
    }

    private int getRightHeight(TreeNode root) {
        int rightHeight = 0;
        while (root.right != null) {
            root = root.right;
            rightHeight++;
        }
        return rightHeight;
    }
}
