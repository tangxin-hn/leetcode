package p131_p140;

import mytool.RandomListNode;

public class P138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null)
            return null;
        RandomListNode temp = head;
        while (temp!=null) {
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        temp = head;
        while (temp!=null) {
            RandomListNode node = temp.next;
            if (temp.random==null)
                node.random=null;
            else
                node.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        RandomListNode head2 = temp.next;
        RandomListNode temp2 = head2;
        while (temp!=null) {
            temp.next = temp.next.next;
            if (temp2.next!=null)
                temp2.next = temp2.next.next;
            else
                temp2.next = null;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}
