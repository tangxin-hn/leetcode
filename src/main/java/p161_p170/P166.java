package p161_p170;

import java.util.HashMap;

public class P166 {
    public static void main(String[] args) {
        P166 t = new P166();
        System.out.println(""+t.fractionToDecimal(1,90));
    }


    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0 || denominator==0)
            return "0";
        StringBuffer stringBuffer = new StringBuffer();
        if ((numerator>0)^(denominator>0))
            stringBuffer.append('-');
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        stringBuffer.append(num/den);
        num = num%den;
        if (num==0)
            return stringBuffer.toString();
        stringBuffer.append('.');

        HashMap<Long,Integer> hashMap = new HashMap<>();
        while (num!=0) {
            num *= 10;
            if (hashMap.containsKey(num)) {
                stringBuffer.append(")");
                stringBuffer.insert(hashMap.get(num),"(");
                break;
            } else {
                hashMap.put(num,stringBuffer.length());
            }
            stringBuffer.append(num/den);
            num %= den;
        }
        return stringBuffer.toString();
    }
}
