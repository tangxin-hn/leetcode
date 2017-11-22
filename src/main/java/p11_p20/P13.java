package p11_p20;

import java.util.HashMap;
import java.util.Map;

public class P13 {

    public static void main(String[] args) {
        P13 t = new P13();
        System.out.println(t.romanToInt("DCXXI"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap();
        m.put('M',1000);
        m.put('D', 500);
        m.put('C', 100);
        m.put('L', 50);
        m.put('X', 10);
        m.put('V', 5);
        m.put('I', 1);
        int n=0;
        for(int i=0;i<s.length();i++) {
            if(i<s.length()-1) {
                if(m.get(s.charAt(i)) < m.get(s.charAt(i+1))) {
                    n = n + m.get(s.charAt(i+1)) - m.get(s.charAt(i));
                    i++;
                } else {
                    n += m.get(s.charAt(i));
                }
            } else {
                n += m.get(s.charAt(i));
            }
        }
        return n;
    }
}
