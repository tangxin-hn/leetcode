package p141_p150;

import mytool.TreeNode;

import java.util.*;

public class P144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root==null)
            return list;
        List<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        while (!treeNodeList.isEmpty()) {
            TreeNode treeNode = treeNodeList.remove(0);
            list.add(treeNode.val);
            if (treeNode.right!=null)
                treeNodeList.add(0,treeNode.right);
            if (treeNode.left!=null)
                treeNodeList.add(0,treeNode.left);
        }
        return list;
    }
}
