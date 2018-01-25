package p101_p110;

import mytool.TreeNode;

public class P105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length)
            return null;
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int start1, int end1, int start2, int end2) {
        if (start1>end1 || start2>end2)
            return null;
        else if (start1==end1)
            return new TreeNode(preorder[start1]);
        TreeNode root = new TreeNode(preorder[start1]);
        int pos1=-1,pos2=-1;
        for (int i=start2;i<=end2;i++) {
            if (inorder[i]==preorder[start1]) {
                pos2 = i;
                break;
            }
        }
        if (pos2 == -1) {
            return null;
        }
        pos1 = start1 + pos2 - start2;
        root.left = buildTree(preorder,inorder,start1+1,pos1,start2,pos2-1);
        root.right = buildTree(preorder,inorder,pos1+1,end1,pos2+1,end2);
        return root;
    }
}
