package P91_P100;

public class P91 {
    public static void main(String[] args) {
        P91 t = new P91();
        String s = "230";
        System.out.println(t.numDecodings2(s));
    }

    //递归
    public int numDecodings(String s) {
        if (s==null || s.length()==0)
            return 0;
        char[] chars = s.toCharArray();
        return numDecodings(chars,0);
    }
    public int numDecodings(char[] chars,int pos) {
        if (pos==chars.length)
            return 1;
        if (chars[pos]-'0'==0)
            return 0;
        if (pos==chars.length-1)
            return 1;
        if ((chars[pos]-'0')*10+chars[pos+1]-'0'>26) {
            return numDecodings(chars,pos+1);
        }
        return numDecodings(chars,pos+1) + numDecodings(chars,pos+2);
    }


    //非递归
    public int numDecodings2(String s) {
        if (s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        if (s.length()==1)
            return 1;
        int[] nums = new int[s.length()];
        nums[0] = 1;
        char[] chars = s.toCharArray();
        if ( (chars[0]-'0')*10+(chars[1]-'0')>26) {
            if (chars[1]=='0')
                return 0;
            else
                nums[1] = 1;
        }
        else if (chars[1]=='0')
            nums[1] = 1;
        else
            nums[1] = 2;
        for (int i=2;i<chars.length;i++) {
            if ((chars[i-1]-'0')*10+(chars[i]-'0')>26 ) {
                if (chars[i]=='0')
                    return 0;
                nums[i] = nums[i-1];
            } else if ((chars[i-1]-'0')*10+(chars[i]-'0')==0) {
                return 0;
            } else if (chars[i]=='0') {
                nums[i] = nums[i-2];
            } else if (chars[i-1]=='0') {
                nums[i] = nums[i-1];
            } else {
                nums[i] = nums[i-1] + nums[i-2];
            }
        }
        return nums[s.length()-1];
    }

    //others
    public int numDecodings3(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
}
