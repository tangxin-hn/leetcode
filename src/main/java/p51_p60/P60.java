package p51_p60;

import java.util.ArrayList;
import java.util.List;

public class P60 {

    public static void main(String[] args) {
        P60 t = new P60();
        System.out.println(t.getPermutation(4,3));
    }

    public String getPermutation(int n, int k) {
        k--;
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

    //others
        public String getPermutation2(int n, int k) {
            int pos = 0;
            List<Integer> numbers = new ArrayList<>();
            int[] factorial = new int[n + 1];
            StringBuilder sb = new StringBuilder();

            // create an array of factorial lookup
            int sum = 1;
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                sum *= i;
                factorial[i] = sum;
            }
            // factorial[] = {1, 1, 2, 6, 24, ... n!}

            // create a list of numbers to get indices
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }
            // numbers = {1, 2, 3, 4}

            k--;

            for (int i = 1; i <= n; i++) {
                int index = k / factorial[n - i];
                sb.append(String.valueOf(numbers.get(index)));
                numbers.remove(index);
                k -= index * factorial[n - i];
            }

            return String.valueOf(sb);
        }
}
