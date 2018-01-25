package p121_p130;

public class P125 {
    public static void main(String[] args) {
        P125 t = new P125();
        System.out.println(t.isPalindrome("Aa"));
    }
    public boolean isPalindrome(String s) {
        if (s==null)
            return true;
        char[] chars = s.toUpperCase().toCharArray();
        int l=0, r=chars.length-1;
        while (l<r) {
            while (illegal(chars[l])) {
                l++;
                if (l>=r)
                    return true;
            }
            while (illegal(chars[r])) {
                r--;
                if (l>=r)
                    return true;
            }
            if (chars[l]!=chars[r])
                return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean illegal(char c) {
        if (c<='9' && c>='0' )
            return false;
        if (c<='Z' && c>='A')
            return false;
        return true;
    }

    //others
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }
}
