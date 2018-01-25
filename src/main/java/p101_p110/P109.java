package p101_p110;

import mytool.*;

public class P109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        int count=0;
        ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            count++;
        }
        int[] num = new int[count];
        temp = head;
        for (int i=0;i<count;i++) {
            num[i] = temp.val;
            temp = temp.next;
        }
        return sortedArrayToBST(num,0,count-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        int i=0;
        if (start>end)
            return null;
        if (start==end)
            return new TreeNode(nums[start]);
        int mid = (end+start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }

    //others
    private ListNode current;
    private int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    private TreeNode sortedListToBSTHelper(int size){
        if (size <= 0){
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - size / 2 - 1);
        root.left = left;
        root.right = right;

        return root;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null){
            return null;
        }
        current = head;
        int size = getSize(head);
        return sortedListToBSTHelper(size);
    }
    //others
    public TreeNode sortedListToBST3(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
}
