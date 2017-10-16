package p1_p10;

public class P7 {
    public static void main(String[] args) {
        P7 t = new P7();
        System.out.println(t.reverse(-123));
    }
    public int reverse(int x) {
        StringBuffer s = new StringBuffer(Integer.toString(x));
        StringBuffer s2 = new StringBuffer("");
        int start=0,end=s.length();
        if(x<0) {
            s2.append('-');
            start = 1;
        }
        for(int i=end-1;i>=start;i--) {
            s2.append(s.charAt(i));
        }
        long t = Long.parseLong(s2.toString());
        if(t>Integer.MAX_VALUE || t<Integer.MIN_VALUE) {
            return 0;
        }
        return (int)t;
    }

    //others
    public int reverse2(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
