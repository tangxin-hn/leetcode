package p121_p130;

import mytool.TreeNode;

public class P129 {
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        return sumNumbers(root,0);

    }
    public int sumNumbers(TreeNode root,int num) {
        num = num*10+root.val;
        if (root.left==null && root.right==null) {
            return num;
        } else if (root.left!=null && root.right!=null) {
            return sumNumbers(root.left,num) + sumNumbers(root.right,num);
        } else if (root.left!=null) {
            return sumNumbers(root.left,num);
        } else {
            return sumNumbers(root.right,num);
        }
    }


    //others
    public int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode node, int sum) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return sum *10 + node.val;
        return sum(node.left, sum*10 + node.val) + sum(node.right, sum *10 +node.val);
    }
}
