package org.ubdev.task.tree.medium;

import org.ubdev.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal{

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rightToLeft = false;
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> currLvl = new LinkedList<>();
            List<TreeNode> nextLvl = new LinkedList<>();
            for(TreeNode node : queue) {
                if (rightToLeft) {
                    currLvl.add(0, node.val);
                } else {
                    currLvl.add(node.val);
                }
                if (node.left != null)
                    nextLvl.add(node.left);
                if (node.right != null)
                    nextLvl.add(node.right);
            }
            result.add(currLvl);
            queue.clear();
            queue.addAll(nextLvl);
            rightToLeft = !rightToLeft;
        }
        return result;
    }
}
