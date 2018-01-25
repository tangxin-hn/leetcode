package p141_p150;

import mytool.ListNode;

public class P147 {
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode redundancy = new ListNode(0);
        redundancy.next = head;
        ListNode tail=head;
        while (tail.next!=null) {
            if (tail.next.val>tail.val) {
                tail = tail.next;
                continue;
            }
            ListNode node = tail.next;
            tail.next = node.next;
            ListNode temp = redundancy;
            while (node.val>temp.next.val)
                temp = temp.next;
            node.next = temp.next;
            temp.next = node;
        }
        return redundancy.next;
    }
}
