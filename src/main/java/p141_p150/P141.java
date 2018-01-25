package p141_p150;

import mytool.ListNode;

public class P141 {
    public boolean hasCycle(ListNode head) {
        ListNode first=head, second=head;
        while (first!=null) {
            if (first.next==null || first.next.next==null)
                return false;
            first = first.next.next;
            second = second.next;
            if (first==second)
                return true;
        }
        return false;
    }
}
