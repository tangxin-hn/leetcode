package p21_p30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P22 {

    public static void main(String[] args) {
        //String s = "{{)}";
        P22 t = new P22();
        System.out.println(t.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        LinkedList<String> list1 = new LinkedList<>();
        if(n<1)
            return list1;
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        list1.add("(");
        list2.add(1);
        list3.add(1);
        for(int i=1;i<2*n;i++) {
            int count = list1.size();
            for(int j=0;j<count;j++) {
                String s = list1.pop();
                int n1 = list2.pop();
                int n2 = list3.pop();
                if (n2 != n) {
                    list1.add(s + "(");
                    list2.add(n1 + 1);
                    list3.add(n2 + 1);
                }
                if (n1 != 0) {
                    list1.add(s + ")");
                    list2.add(n1 - 1);
                    list3.add(n2);
                }
            }
        }
        return list1;
    }

    //others
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
