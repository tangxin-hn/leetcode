package p141_p150;

import mytool.ListNode;

public class P142 {
    public ListNode detectCycle(ListNode head) {
        ListNode node = hasCycle(head);

        if (node==null)
            return null;
        ListNode first=node, second=node;
        int count=0;
        while (true) {
            first=first.next.next;
            second=second.next;
            count++;
            if (first==second)
                break;
        }

        first=head;
        second=head;
        for (int i=0;i<count;i++)
            first = first.next;
        while (first!=second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
    public ListNode hasCycle(ListNode head) {
        ListNode first=head, second=head;
        while (first!=null) {
            if (first.next==null || first.next.next==null)
                return null;
            first = first.next.next;
            second = second.next;
            if (first==second)
                return first;
        }
        return null;
    }

    //others 只适应于循环较长的情况
    public ListNode detectCycle2(ListNode head) {
        if (head==null || head.next==null)
            return null;
        ListNode first=head,second=head;
        boolean isCycle = false;

        while (second!=null) {
            first = first.next;
            if (second.next==null)
                return  null;
            second = second.next.next;
            if (first==second) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle)
            return null;
        while (first!=second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }
}
