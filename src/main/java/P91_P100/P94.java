package p91_p100;

import mytool.TreeNode;

import java.util.*;

public class P94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root!=null)
            inorderTraversal(root,list);
        return list;
    }
    public void inorderTraversal(TreeNode root,List<Integer> list) {
        if (root.left!=null)
            inorderTraversal(root.left,list);
        list.add(root.val);
        if (root.right!=null)
            inorderTraversal(root.right,list);
    }
}
