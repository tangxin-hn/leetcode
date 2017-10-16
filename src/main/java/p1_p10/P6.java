package p1_p10;

public class P6 {
    public static void main(String[] args) {
        P6 t = new P6();
        System.out.println(t.convert("PAYPALISHIRING", 3));
    }
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0;i<numRows;i++) {
            sb[i] = new StringBuffer("");
        }
        int r = 2*numRows-2;
        for(int i=0;i<s.length();i++) {
            int t = i%r;
            if(t<numRows) {
                sb[t].append(s.charAt(i));
            } else {
                sb[2*numRows-t-2].append(s.charAt(i));
            }
        }
        for(int i=1;i<numRows;i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    //others
    public String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
