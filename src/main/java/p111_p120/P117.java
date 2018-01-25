package p111_p120;

import mytool.TreeLinkNode;

public class P117 {
    public void connect(TreeLinkNode root) {
        if (root==null)
            return;
        if (root.left==null && root.right==null)
            return;
        TreeLinkNode temp = root.next;
        while (temp!=null) {
            if (temp.left!=null) {
                temp = temp.left;
                break;
            } else if (temp.right!=null) {
                temp = temp.right;
                break;
            } else {
                temp = temp.next;
            }
        }
        if (root.left!=null) {
            if (root.right!=null)
                root.left.next = root.right;
            else {
                root.left.next = temp;
            }
        }
        if (root.right!=null)
            root.right.next = temp;
        connect(root.right);
        connect(root.left);
    }
}
