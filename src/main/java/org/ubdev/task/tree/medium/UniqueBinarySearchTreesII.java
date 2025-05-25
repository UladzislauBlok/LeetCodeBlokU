package org.ubdev.task.tree.medium;

import org.ubdev.domain.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesInRange(1, n); // can be done better using memorization
    }

    private List<TreeNode> generateTreesInRange(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
        } else {
            for(int i = start; i <= end; i++) { // All nums in [start; end] can be a root
                List<TreeNode> left = generateTreesInRange(start, i - 1);
                List<TreeNode> right = generateTreesInRange(i + 1, end);
                for(TreeNode leftNode : left) {
                    for(TreeNode rightNode : right) { // all possible combination
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}
