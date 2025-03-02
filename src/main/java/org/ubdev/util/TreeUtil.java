package org.ubdev.util;

import org.ubdev.domain.TreeNode;

import java.util.List;

public class TreeUtil {
    private TreeUtil() {}

    public static TreeNode buildTreeNode(List<Integer> nodeValues) {
        List<TreeNode> nodes = nodeValues.stream()
                .map(TreeNode::new)
                .toList();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (i + i + 1 < nodes.size()) {
                node.left = nodes.get(i + i + 1);
            }
            if (i + i + 2 < nodes.size()) {
                node.right = nodes.get(i + i + 2);
            }
        }
        return nodes.isEmpty() ? null : nodes.getFirst();
    }
}
