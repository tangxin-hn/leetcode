package p101_p110;

import mytool.TreeNode;

public class P101 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode l,TreeNode r) {
        if (l==null && r==null)
            return true;
        if (l==null || r==null)
            return false;
        if (l.val!=r.val)
            return false;
        return isSameTree(l.left,r.right) && isSameTree(l.right,r.left);
    }
}
