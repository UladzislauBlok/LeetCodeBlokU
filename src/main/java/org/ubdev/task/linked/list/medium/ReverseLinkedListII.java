package org.ubdev.task.linked.list.medium;

import org.ubdev.domain.ListNode;

class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode temp;
        ListNode leftNode = curr;
        ListNode leftPrevNode = prev;
        for (int i = left; i <= right; i++) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        leftNode.next = curr;
        leftPrevNode.next = prev;
        return dummyHead.next;
    }
}
