package org.ubdev.task.linked.list.medium;

import org.ubdev.domain.ListNode;

public class RemoveDuplicatesSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pointer = dummyHead;
        int lastVal = Integer.MIN_VALUE;
        while (head.next != null) {
            if (head.val != lastVal && head.val != head.next.val) {
                pointer.next = new ListNode(head.val);
                pointer = pointer.next;
            }
            lastVal = head.val;
            head = head.next;
        }
        if (head.val != lastVal) {
            pointer.next = new ListNode(head.val);
        }
        return dummyHead.next;
    }
}
