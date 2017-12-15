package P91_P100;

import mytool.TreeNode;

public class P100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==q)
            return true;
        if (p==null || q==null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
