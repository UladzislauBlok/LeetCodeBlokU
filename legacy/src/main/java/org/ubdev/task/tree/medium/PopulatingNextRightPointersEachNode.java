package org.ubdev.task.tree.medium;

import java.util.ArrayDeque;
import java.util.Queue;

class PopulatingNextRightPointersEachNode {

    // Lvl traversal - Queue
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int lvlSize = queue.size();
            for(int i = 0; i < lvlSize - 1; i++) {
                Node curr = queue.poll();
                curr.next = queue.peek();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            Node curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
