package p161_p170;

public class P168 {
    public static void main(String[] args) {
        P168 t = new P168();
        System.out.println(""+t.convertToTitle(53));
    }

    public String convertToTitle(int n) {
        if (n<1)
            return "";
        StringBuffer stringBuffer = new StringBuffer();
        while (n>0) {
            char t = (char)((n-1)%26 + 'A');
            stringBuffer.insert(0,t);
            if (n%26==0)
                n = n/26-1;
            else
                n = n/26;
        }
        return stringBuffer.toString();
    }
}
