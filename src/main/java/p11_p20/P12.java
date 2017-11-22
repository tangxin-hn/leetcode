package p11_p20;

import java.util.Random;

public class P12 {

    public static void main(String[] args) {
        P12 t = new P12();
        for(int i=0;i<10;i++) {
            int n = (int)(Math.random()*4000);
            System.out.print(n + ":");
            System.out.println(t.intToRoman(n));
        }
    }

    public String intToRoman(int num) {
        int[] n = new int[4];
        char[] c1 = {'I','X','C','M'};
        char[] c2 = {'V','L','D'};
        for(int i=0;i<4;i++) {
            n[i] = num%10;
            num = num/10;
        }
        for(int i=0;i<4;i++) {
            if(n[i]>=9) {
                n[i+1] ++;
                n[i] = n[i]-10;
            }
        }
        StringBuffer sb = new StringBuffer("");

        for(int i=0;i<4;i++) {
            if(n[i]<0) {
                sb.append(c1[i]);
            }
        }
        for(int i=3;i>=0;i--) {
            if(n[i]>=5) {
                sb.append(c2[i]);
                n[i]-=5;
            }
            if(n[i]==4) {
                sb.append(c1[i]);
                sb.append(c2[i]);
            } else {
                for(int j=0;j<n[i];j++) {
                    sb.append(c1[i]);
                }
            }
        }
        return sb.toString();
    }

    //others 3999是MMMCMXCIX而不是MMMIM
    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
