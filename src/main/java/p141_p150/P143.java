package p141_p150;

import mytool.ListNode;

public class P143 {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null)
            return;

        ListNode temp=head;
        int count=1;
        while (temp!=null) {
            count++;
            temp = temp.next;
        }

        temp = head;
        for (int i=0;i<count/2-1;i++)
            temp = temp.next;
        ListNode head2 = temp.next;
        temp.next = null;

        ListNode tail=head2;
        while (tail.next!=null) {
            ListNode node = tail.next;
            tail.next = node.next;
            node.next = head2;
            head2 = node;
        }

        temp = head;
        while (head2!=null) {
            ListNode node = head2;
            head2 = head2.next;
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
    }

    //others
    public void reorderList2(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
