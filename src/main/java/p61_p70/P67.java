package p61_p70;

public class P67 {
    public String addBinary(String a, String b) {
        int[] x = new int[a.length()];
        for (int i=0;i<a.length();i++)
            x[i] = a.charAt(a.length()-1-i) - '0';
        int[] y = new int[b.length()];
        for (int i=0;i<b.length();i++)
            y[i] = b.charAt(b.length()-1-i) - '0';
        if (x.length<y.length) {
            int[] t = x;
            x = y;
            y = t;
        }
        int flag=0;
        for (int i=0;i<y.length;i++) {
            x[i] = x[i] + y[i] + flag;
            flag = x[i]/2;
            x[i] %= 2;
        }
        for (int i=y.length;i<x.length && flag==1;i++) {
            x[i] = x[i] + flag;
            flag = x[i]/2;
            x[i] %= 2;
        }
        StringBuffer sb = new StringBuffer();
        if (flag==1)
            sb.append('1');
        for (int i=x.length-1;i>=0;i--)
            sb.append(Integer.toString(x[i]));
        return sb.toString();
    }

    //others
    public String addBinary2(String a, String b) {
        if (a.length() > b.length()) {
            // add to arr1
            return addToA(a.toCharArray(), b);
        } else {
            // add to arr2
            return addToA(b.toCharArray(), a);
        }
    }

    private String addToA(char[] a, String b) {
        int x = a.length - 1;
        int y = b.length() - 1;
        int remain = 0;
        while (y >= 0) {
            int sum = remain + a[x] - '0' + b.charAt(y) - '0';
            a[x--] = (char)(sum % 2 + '0');
            remain = sum / 2;
            y--;
        }
        while (x >= 0 && remain > 0) {
            int sum = remain + a[x] - '0';
            a[x--] = (char)(sum % 2 + '0');
            remain = sum / 2;
        }
        if (remain == 0) {
            return String.valueOf(a);
        } else {
            return "1" + String.valueOf(a);
        }
    }
}
