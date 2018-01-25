package p141_p150;

import mytool.ListNode;

public class P148 {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null) {
            if (fast.next==null || fast.next.next==null)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head = sortList(head);
        head2 = sortList(head2);

        ListNode redundancy = new ListNode(0);
        ListNode tail = redundancy;
        while (head!=null && head2!=null) {
            if (head.val<head2.val) {
                tail.next = head;
                head = head.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
            tail.next = null;
        }

        if (head!=null)
            tail.next = head;
        if (head2!=null)
            tail.next = head2;

        return redundancy.next;
    }
}
