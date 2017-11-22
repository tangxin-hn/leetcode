package p51_p60;

import java.util.ArrayList;
import java.util.List;

public class P60 {

    public static void main(String[] args) {
        P60 t = new P60();
        System.out.println(t.getPermutation(3,1));
    }

    public String getPermutation(int n, int k) {
        if (n==1 && k==1)
            return "1";
        int[] t = new int[n];
        for (int i=0;i<n;i++) {
            t[i] = k/factorial(n-i-1);
            k = k%factorial(n-i-1);
        }
        List<Integer> t2 = new ArrayList<>();
        for (int i=1;i<=n;i++)
            t2.add(i);
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<n;i++) {
            sb.append(Integer.toString(t2.get(t[i])));
            t2.remove(t[i]);
        }
        return sb.toString();
    }
    public int factorial(int n) {
        int result=1;
        for (int i=1;i<=n;i++)
            result *=i;
        return result;
    }
}
