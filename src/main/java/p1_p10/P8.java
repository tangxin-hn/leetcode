package p1_p10;

public class P8 {
    public static void main(String[] args) {
        P8 t = new P8();
        System.out.println(t.myAtoi(""));
    }
    public int myAtoi(String str) {
        if (str==null)
            return 0;
        if (str.equals(""))
            return 0;
        int flag = 0;
        int start=0;
        char[] c = str.toCharArray();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]!=' ') {
                start = i;
                break;
            }
            if(i==c.length-1)
                return 0;
        }
        if(c[start]=='-') {
            flag = 1;
            start++;
        }else if(c[start]=='+') {
            start++;
        }

        long n=0;
        for(int i=start;i<c.length;i++) {
            if(c[i]-'0'>9 || c[i]-'0'<0)
                break;
            n = (c[i]-'0') + n * 10;
            if(flag==0 && n>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(flag==1 && 0-n<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        if(flag==1)
            return (int)(0-n);
        return (int)n;
    }
}
