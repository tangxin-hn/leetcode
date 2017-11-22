package p11_p20;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P20 {
    public static void main(String[] args) {
        String s = "{{)}";
        P20 t = new P20();
        System.out.println(t.isValid(s));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> list = new LinkedList<>();
        list.add('(');
        list.add('[');
        list.add('{');
        for(int i=0;i<s.length();i++) {
            if(list.contains(s.charAt(i)))
                stack.push(s.charAt(i));
            else {
                if(stack.empty())
                    return false;
                if(s.charAt(i)-stack.peek()!=2 && s.charAt(i)-stack.peek()!=1)
                    return false;
                stack.pop();
            }
        }
        return stack.empty();
    }

    //others
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
