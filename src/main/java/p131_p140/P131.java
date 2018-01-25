package p131_p140;

import java.util.*;

public class P131 {
    public static void main(String[] args) {
        P131 t = new P131();
        System.out.println(t.partition("aabaa"));
    }

    //递归
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new LinkedList<>();
        if (s==null || s.length()==0)
            return lists;
        char[] chars = s.toCharArray();
        List<String> list = new LinkedList<>();
        partition(chars,lists,list,0);
        return lists;
    }
    public void partition(char[] chars,List<List<String>> lists,List<String> list,int pos) {
        if (pos==chars.length) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i=pos;i<chars.length;i++) {
            if (isPartition(chars,pos,i)) {
                list.add(new String(chars,pos,i-pos+1));
                partition(chars,lists,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPartition(char[] chars,int begin,int end) {
        while (begin<end) {
            if (chars[begin]!=chars[end])
                return false;
            begin++;
            end--;
        }
        return true;
    }
}
