package org.ubdev.task.tree.medium;

import org.ubdev.domain.TreeNode;

class SumRootLeafNumbers {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int currSum) {
        if (root.left == null && root.right == null) {
            sum += (currSum + root.val);
            return;
        }
        if (root.left != null)
            sumNumbers(root.left, (currSum + root.val) * 10);
        if (root.right != null)
            sumNumbers(root.right, (currSum + root.val) * 10);
    }
}
