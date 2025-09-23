package org.bloku.util;

import org.bloku.domain.ListNode;

import java.util.List;

public class ListUtil {

    public static ListNode buildListNode(List<Integer> nodeValues) {
        ListNode head = new ListNode(nodeValues.getFirst());
        ListNode curr = head;
        for (int i = 1; i < nodeValues.size(); i++) {
            curr.next = new ListNode(nodeValues.get(i));
            curr = curr.next;
        }
        return head;
    }
}
