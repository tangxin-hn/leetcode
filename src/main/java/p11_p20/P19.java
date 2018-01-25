package p11_p20;
import mytool.*;
public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp = head;
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        if(count<n)
            return head;
        if(count==n)
            return head.next;
        temp = head;
        for(int i=0;i<count-n-1;i++)
            temp = temp.next;
        temp.next = temp.next.next;
        return head;
    }

    //others
    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
