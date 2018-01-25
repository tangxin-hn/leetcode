package p111_p120;

import mytool.TreeNode;

import java.util.*;

public class P113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root==null)
            return listList;
        List<Integer> list = new LinkedList<>();
        findPathSum(root,sum,listList,list);
        return listList;
    }
    public void findPathSum(TreeNode root,int sum,List<List<Integer>> listList,List<Integer> list) {
        if (root.left==null && root.right==null) {
            if (root.val==sum) {
                list.add(root.val);
                listList.add(new LinkedList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        if (root.left!=null)
            findPathSum(root.left,sum-root.val,listList,list);
        if (root.right!=null)
            findPathSum(root.right,sum-root.val,listList,list);
        list.remove(list.size()-1);
    }
}
