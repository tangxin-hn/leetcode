package p81_p90;
import mytool.*;

public class P82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode tt = t;
        boolean flag = false;
        while (tt!=null && tt.next!=null) {
            while (tt.next.next!=null && tt.next.val==tt.next.next.val){
                tt.next = tt.next.next;
                flag = true;
            }
            if (flag) {
                flag = false;
                tt.next = tt.next.next;
            } else
                tt = tt.next;
        }
        return t.next;
    }

    //others
    public ListNode deleteDuplicates2(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = fast.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
}
