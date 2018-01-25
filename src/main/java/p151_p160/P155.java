package p151_p160;

import java.util.Stack;

public class P155 {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public P155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty())
            minStack.push(x);
        else {
            int temp = minStack.peek();
            if (temp<x)
                minStack.push(temp);
            else
                minStack.push(x);
        }
    }

    public void pop() {
        if (stack.empty())
            return;
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    //others
    public class MinStack {
        long min;
        Stack<Long> stack;

        public MinStack(){
            stack=new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(0L);
                min=x;
            }else{
                stack.push(x-min);//Could be negative if min value needs to change
                if (x<min) min=x;
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            long pop=stack.pop();

            if (pop<0)  min=min-pop;//If negative, increase the min value

        }

        public int top() {
            long top=stack.peek();
            if (top>0){
                return (int)(top+min);
            }else{
                return (int)(min);
            }
        }

        public int getMin() {
            return (int)min;
        }
    }


    class MinStack2 {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if(x <= min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if(stack.pop() == min) min=stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
