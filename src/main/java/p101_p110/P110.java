package p101_p110;

import mytool.TreeNode;

public class P110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        return deepth(root)==-1?false:true;
    }
    public int deepth(TreeNode root) {
        if (root==null)
            return 0;
        int dl = deepth(root.left);
        int dr = deepth(root.right);
        if (dl==-1 || dr==-1)
            return -1;
        if (Math.abs(dl-dr)>1)
            return -1;
        return Math.max(dl,dr)+1;
    }
}
