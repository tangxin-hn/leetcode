package p101_p110;

import mytool.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int count = 0;
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
                count++;
                List<Integer> templist = null;
                if ((count&1)==0) {
                    templist = new LinkedList<>();
                    for (int j= list.size()-1;j>=0;j--)
                        templist.add(list.get(j));
                    list = templist;
                }
                listList.add(list);
                list = new LinkedList<>();
                pos = treeNodeList.size();
            }
        }
        return listList;
    }
}
