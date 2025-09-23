package org.ubdev.task.tree.medium;

import org.ubdev.domain.TreeNode;

class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0,0};

        int[] leftDfs = dfs(root.left);
        int[] rightDfs = dfs(root.right);
        int[] result = new int[2]; // [0] - rob current. [1] - skip current
        result[0] = root.val + leftDfs[1] + rightDfs[1];
        result[1] = Math.max(leftDfs[0], leftDfs[1]) + Math.max(rightDfs[0], rightDfs[1]);
        return result;
    }
}
