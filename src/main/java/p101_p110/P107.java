package p101_p110;

import mytool.TreeNode;

import java.util.*;

public class P107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root==null)
            return listList;
        List<Integer> list = new LinkedList<>();
        List<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        int count = treeNodeList.size();
        while (treeNodeList.size()!=0) {
            TreeNode temp = treeNodeList.get(0);
            list.add(temp.val);
            if (temp.left!=null)
                treeNodeList.add(temp.left);
            if (temp.right!=null)
                treeNodeList.add(temp.right);
            count--;
            treeNodeList.remove(0);
            if (count==0) {
                listList.add(0,list);
                list = new LinkedList<>();
                count = treeNodeList.size();
            }
        }
        return listList;
    }

    //others 递归
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) return out;

        traverse(out, root, 0);

        Collections.reverse(out);

        return out;
    }

    public void traverse(List<List<Integer>> out, TreeNode root, int depth) {

        if ( root == null) return;

        // The slow will increase gradualy one by one -> add a new list when reaching a new depth
        if ( depth == out.size() ) out.add(new ArrayList<Integer>());

        traverse(out, root.left, depth+1);


        out.get(depth).add(root.val);


        traverse(out, root.right, depth+1);
    }
}
