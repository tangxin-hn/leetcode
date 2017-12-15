package P81_P90;

import mytool.ListNode;

public class P86 {
    public static void main(String[] args) {
        P86 t = new P86();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head = t.partition(head,2);
        for (ListNode temp=head;temp!=null;temp=temp.next)
            System.out.println(temp.val);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy2 = new ListNode(0),last2 = dummy2;
        ListNode temp = dummy;
        while (temp.next!=null) {
            if (temp.next.val>=x) {
                last2.next = temp.next;
                temp.next = temp.next.next;
                last2 = last2.next;
                last2.next = null;
            } else
                temp = temp.next;
        }
        temp.next = dummy2.next;
        return dummy.next;
    }
}
