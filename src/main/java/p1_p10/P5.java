package p1_p10;

public class P5 {
    public static void main(String[] args) {
        P5 t = new P5();
        System.out.println(t.longestPalindrome2("babad"));
    }
    public static String longestPalindrome(String s) {
        if(s==null)
            return "";
        if(s.length()==0) {
            return "";
        } else if (s.length()==1){
            return s;
        }
        StringBuffer result = new StringBuffer("");
        StringBuffer sb = new StringBuffer(s);

        sb.reverse();
        int len = sb.length();
        for(int i=len-1;i>=result.length();i--) {
            int start = sb.indexOf(sb.substring(i, i + 1));
            StringBuffer t = new StringBuffer(sb.substring(start, i+1));
            if(result.length()>i)
                break;
            while (t.length()>result.length()) {
                if (isPalindrome(t)) {
                    result = t;
                    break;
                } else {
                    t.delete(0,1);
                    if(t.length()==0)
                        break;
                    start = t.indexOf(sb.substring(i, i + 1));
                    t.delete(0,start);
                }
            }
        }
        result.reverse();
        return result.toString();
    }
    public static boolean isPalindrome(StringBuffer s) {
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    ///others
    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
