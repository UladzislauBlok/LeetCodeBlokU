package org.ubdev.task.linked.list.medium;

import org.ubdev.domain.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        int numOfNodes = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            numOfNodes++;
        }
        if (k % numOfNodes == 0)
            return head;
        int rotatePoint = numOfNodes - k % numOfNodes;
        ListNode current = head;
        while (rotatePoint > 1) {
            current = current.next;
            rotatePoint--;
        }
        ListNode newHead = current.next;
        current.next = null;
        last.next = head;
        return newHead;
    }
}
