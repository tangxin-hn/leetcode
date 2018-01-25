package p101_p110;

import mytool.TreeNode;

public class P104 {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(maxDepth(root.right),maxDepth(root.right))+1;
    }
}
