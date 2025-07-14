package org.ubdev.task.linked.list.easy;

import org.ubdev.domain.ListNode;

public class ConvertBinaryNumberLinkedListInteger {

    public int getDecimalValue(ListNode head) {
        int degree = -1;
        ListNode tv = head;
        while (tv != null) {
            degree++;
            tv = tv.next;
        }
        tv = head;
        int pow = 1 << degree;
        int res = 0;
        while(tv != null) {
            if (tv.val == 1) {
                res += pow;
            }
            pow /= 2;
            tv = tv.next;
        }
        return res;
    }
}
