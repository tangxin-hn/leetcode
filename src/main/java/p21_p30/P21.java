package p21_p30;

public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode h1 = l1.val<l2.val?l1:l2;
        ListNode head = h1;
        ListNode h2 = l1.val<l2.val?l2:l1;
        while(h1.next!=null && h2!=null) {
            if(h1.next.val<h2.val)
                h1 = h1.next;
            else {
                ListNode t = h2;
                while(h2.next!=null) {
                    if(h2.next.val>h1.next.val)
                        break;
                    h2 = h2.next;
                }
                ListNode t2 = h2;
                h2 = h2.next;
                t2.next = h1.next;
                h1.next = t;
                h1 = t2;
            }
        }
        if(h2!=null) {
            h1.next = h2;
        }
        return head;
    }

    //others
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
