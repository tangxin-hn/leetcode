package P91_P100;

import mytool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P95 {
    public static void main(String[] args) {
        P95 t = new P95();
        System.out.println(t.generateTrees2(4));
    }
    //错误，会有重复
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeList = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        if(n<1)
            return treeList;
        generateTrees(treeList,tempList,n);
        return treeList;
    }
    public void generateTrees(List<TreeNode> treeList,List<Integer> tempList,int n) {
        if (tempList.size()==n) {
            TreeNode root = generateTree(tempList);
            treeList.add(root);
            return;
        }
        for (int i=1;i<=n;i++) {
            if (tempList.contains(i))
                continue;
            if (tempList.size()>=2 && tempList.get(tempList.size()-1)>tempList.get(tempList.size()-2) && i<tempList.get(tempList.size()-2))
                continue;
            tempList.add(i);
            generateTrees(treeList,tempList,n);
            tempList.remove(tempList.size()-1);
        }
    }
    public TreeNode generateTree(List<Integer> tempList) {
        TreeNode root = new TreeNode(tempList.get(0));
        for (int i=1;i<tempList.size();i++) {
            TreeNode treeNode = new TreeNode(tempList.get(i));
            insertTreeNode(root,treeNode);
        }
        return root;
    }
    public void insertTreeNode(TreeNode root,TreeNode treeNode) {
        if (treeNode.val<root.val) {
            if (root.left==null)
                root.left=treeNode;
            else
                insertTreeNode(root.left,treeNode);
        } else {
            if (root.right==null)
                root.right=treeNode;
            else
                insertTreeNode(root.right,treeNode);
        }
    }

    //others
    public List<TreeNode> generateTrees2(int n) {
        if (n<1)
            return new ArrayList<TreeNode>();
        return genTrees(1,n);
    }

    public List<TreeNode> genTrees (int start, int end)
    {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
}
