package p151_p160;

import mytool.ListNode;

public class P160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        ListNode tempA2 = headA, tempB2 = headB;
        while (tempA!=null && tempB!=null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        while (tempA!=null) {
            tempA = tempA.next;
            tempA2 = tempA2.next;
        }
        while (tempB!=null) {
            tempB = tempB.next;
            tempB2 = tempB2.next;
        }
        while (tempA2!=null && tempB2!=null && tempA2!=tempB2) {
            tempA2 = tempA2.next;
            tempB2 = tempB2.next;
        }
        return tempA2;
    }
}
