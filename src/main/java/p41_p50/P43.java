package p41_p50;

public class P43 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,5,6};
        P43 t = new P43();
        System.out.println(t.multiply("99","20"));
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int[] carry = new int[num1.length()+num2.length()];
        int[] result = new int[num1.length()+num2.length()];
        for (int i=0;i<num1.length()+num2.length()-1;i++) {
            int r=0;
            for (int j=0;j<=i && j<num1.length();j++) {
                if (i-j<num2.length())
                    r +=  (num1.charAt(num1.length()-j-1)-'0') * (num2.charAt(num2.length()-i+j-1)-'0');
            }
            r += carry[i];
            carry[i+1] = r/10;
            result[i] = r%10;
        }
        result[num1.length()+num2.length()-1] = carry[num1.length()+num2.length()-1];
        StringBuffer stringBuffer = new StringBuffer();
        if (result[result.length-1]!=0)
            stringBuffer.append(result[num1.length()+num2.length()-1]);
        for (int i=result.length-2;i>=0;i--) {
            stringBuffer.append(result[i]);
        }
        return stringBuffer.toString();
    }

    //others
    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
