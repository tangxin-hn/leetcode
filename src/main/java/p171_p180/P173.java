package p171_p180;

import mytool.TreeNode;

import java.util.Stack;

public class P173 {
    public class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            TreeNode temp = root;
            while (temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.empty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode temp = stack.pop();
            int next = temp.val;
            temp = temp.right;
            while (temp!=null) {
                stack.push(temp);
                temp = temp.left;
            }
            return next;
        }
    }
}
