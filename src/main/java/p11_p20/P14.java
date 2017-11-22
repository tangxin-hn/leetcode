package p11_p20;

public class P14 {
    public static void main(String[] args) {
        String[] strs={"abc","abdd","asss","adss"};
        P14 t = new P14();
        System.out.println(t.longestCommonPrefix2(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) {
            return strs[0];
        } else if(strs.length==0) {
            return "";
        }
        String maxPre = findPrefix(strs[0], strs[1]);
        for(int i=2;i<strs.length && maxPre.length()!=0;i++) {
            maxPre = findPrefix(maxPre, strs[i]);
        }
        if(maxPre.length()==0) {
            return "";
        }
        return maxPre;
    }
    public String findPrefix(String s1, String s2) {
        int i=0;
        for(i=0;i<s1.length() && i<s2.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0,i);
    }

    //others
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
