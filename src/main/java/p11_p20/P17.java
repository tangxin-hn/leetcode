package p11_p20;

import java.util.LinkedList;
import java.util.List;

public class P17 {
    public static void main(String[] args) {
        String digits = new String("23");
        P17 t = new P17();
        System.out.println(t.letterCombinations(digits));
    }
    public List<String> letterCombinations(String digits) {
        List<String> l = new LinkedList<>();
        if (digits == null)
            return l;
        if (digits.length()==0)
            return l;
        char[][] c ={{'a','b','c'}, {'d','e','f'},
                {'g','h','i'}, {'j','k','l'}, {'m','n','o'},
                {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
        int count = 1;
        for(int i=0;i<digits.length();i++) {
            count *= c[digits.charAt(i)-'0'-2].length;
        }
        for (int i=0; i<count; i++) {
            StringBuffer sb = new StringBuffer("");
            int temp=i;
            for(int j=0;j<digits.length();j++) {
                sb.append(c[digits.charAt(j)-'0'-2][temp%c[digits.charAt(j)-'0'-2].length]);
                temp = temp/c[digits.charAt(j)-'0'-2].length;
            }
            l.add(sb.toString());
        }
        return l;
    }


    //others
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
