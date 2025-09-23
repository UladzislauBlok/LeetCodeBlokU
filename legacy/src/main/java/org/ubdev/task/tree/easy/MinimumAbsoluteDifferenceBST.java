package org.ubdev.task.tree.easy;

import org.ubdev.domain.TreeNode;

class MinimumAbsoluteDifferenceBST {

    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        if (root == null)
            return minDiff;
        if (root.right != null) {
            TreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            minDiff = Math.min(minDiff, right.val - root.val);
        }
        if (root.left != null) {
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            minDiff = Math.min(minDiff, root.val - left.val);
        }
        minDiff = Math.min(minDiff, getMinimumDifference(root.left));
        minDiff = Math.min(minDiff, getMinimumDifference(root.right));
        return minDiff;
    }
}
