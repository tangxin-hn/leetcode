package p111_p120;

import mytool.TreeNode;

public class P114 {
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        flatten(root.left);
        flatten(root.right);
        if (root.left==null)
            return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        if (temp==null)
            return;
        TreeNode temp2 = root;
        while (temp2.right!=null)
            temp2 = temp2.right;
        temp2.right = temp;
        return;
    }

    //others
    private TreeNode prev = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
