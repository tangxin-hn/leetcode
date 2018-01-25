package p111_p120;

import mytool.TreeLinkNode;

import java.util.*;

public class P116 {
    public void connect(TreeLinkNode root) {
        if (root==null)
            return;
        List<TreeLinkNode> list = new LinkedList<>();
        list.add(root);
        int count = list.size();
        while (count!=0) {
            TreeLinkNode temp = list.get(0);
            list.remove(0);
            count--;
            if (temp==null)
                continue;
            list.add(temp.left);
            list.add(temp.right);
            if (count==0) {
                temp.next = null;
                count = list.size();
            } else {
                temp.next = list.get(0);
            }
        }
    }

    //others
    public void connect2(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null){
            root.left.next=root.right;
            if(root.next!=null)
                root.right.next=root.next.left;
        }
        connect2(root.left);
        connect2(root.right);
    }
}
