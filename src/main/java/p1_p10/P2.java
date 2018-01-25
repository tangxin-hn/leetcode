package p1_p10;
import mytool.*;

public class P2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1,t2=l2;
        int flag = 0;
        while (t1!=null && t2!=null) {
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1==null){
            t1 = l2;
            t2 = l1;
            l1 = t1;
            l2 = t2;
        } else {
            t1 = l1;
            t2 = l2;
        }
        while(t2!=null) {
            int n = t1.val + t2.val + flag;
            t1.val = n%10;
            flag = n/10;
            if(t1.next==null) {
                if(flag>0) {
                    t1.next = new ListNode(flag);
                    flag = 0;
                }
                break;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        while(flag==1 && t1!=null) {
            int n = t1.val + flag;
            t1.val = n%10;
            flag = n/10;
            if(t1.next==null) {
                if(flag>0) {
                    t1.next = new ListNode(flag);
                    flag = 0;
                }
                break;
            }
            t1 = t1.next;
        }
        return l1;
    }

    //others
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
