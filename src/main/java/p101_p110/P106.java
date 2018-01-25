package p101_p110;

import mytool.TreeNode;

public class P106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0 || inorder.length!=postorder.length)
            return null;
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int start1, int end1, int start2, int end2) {
        if (start1>end1 || start2>end2)
            return null;
        if (start1==end1)
            return new TreeNode(inorder[start1]);
        TreeNode root = new TreeNode(postorder[end2]);
        int pos1=-1,pos2=-1;
        for (int i=start1;i<=end1;i++) {
            if (inorder[i]==postorder[end2]) {
                pos1 = i;
                break;
            }
        }
        if (pos1==-1)
            return null;
        pos2 = end2 - (end1-pos1);
        root.left = buildTree(inorder,postorder,start1,pos1-1,start2,pos2-1);
        root.right = buildTree(inorder,postorder,pos1+1,end1,pos2,end2-1);
        return root;
    }
}
