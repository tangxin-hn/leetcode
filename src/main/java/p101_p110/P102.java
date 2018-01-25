package p101_p110;

import mytool.TreeNode;

import java.util.*;

public class P102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root==null)
            return listList;
        List<Integer> list = new LinkedList<>();
        List<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        int pos = 1;
        while (treeNodeList.size()!=0) {
            TreeNode tempNode = treeNodeList.get(0);
            list.add(tempNode.val);
            if (tempNode.left!=null)
                treeNodeList.add(tempNode.left);
            if (tempNode.right!=null)
                treeNodeList.add(tempNode.right);
            pos--;
            treeNodeList.remove(0);
            if (pos==0) {
                listList.add(list);
                list = new LinkedList<>();
                pos = treeNodeList.size();
            }
        }
        return listList;
    }
}
