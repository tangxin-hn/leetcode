package p61_p70;

import mytool.ListNode;

public class P61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null ||k==0)
            return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        int length=0;
        ListNode temp = fake;
        while (temp.next!=null){
            length++;
            temp = temp.next;
        }
        k = k%length;

        if (k==0)
            return head;
        ListNode lastPos=temp;
        temp = fake;
        for(int i=0;i<length-k;i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        lastPos.next = fake.next;
        return head;
    }
}
