package p141_p150;

import java.util.Stack;

public class P150 {
    public int evalRPN(String[] tokens) {
        if (tokens==null)
            return 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<tokens.length;i++) {
            if (tokens[i].equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second+first);
            } else if (tokens[i].equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second-first);
            } else if (tokens[i].equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second*first);
            } else if (tokens[i].equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            } else {
                stack.push(new Integer(tokens[i]));
            }
        }
        return stack.pop();
    }
}
