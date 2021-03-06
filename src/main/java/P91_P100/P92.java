package p91_p100;

import mytool.ListNode;

public class P92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m==n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pm=null,pn=null;
        ListNode temp = dummy,temp2=null;
        ListNode head2=null,tail=null;
        for (int i=0;i<=n;i++) {
            if (i==m-1)
                pm = temp;
            if (i<m) {
                temp = temp.next;
                continue;
            }
            if (i==n)
                pn = temp.next;
            if (tail==null)
                tail = temp;
            temp2 = head2;
            head2 = temp;
            temp = temp.next;
            head2.next = temp2;
        }
        pm.next = head2;
        tail.next = pn;
        return dummy.next;
    }

    //others
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }
}
