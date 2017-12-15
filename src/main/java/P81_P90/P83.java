package P81_P90;

import mytool.ListNode;

public class P83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy,fast = head;
        while (fast!=null) {
            while (fast.next!=null && fast.val==fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
