package p61_p70;

public class P66 {
    public int[] plusOne(int[] digits) {
        int flag=1,i=0;
        for (i=0;i<digits.length && digits[i]==9;i++);
        if (i==digits.length)
        {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        for (i=digits.length-1;i>=0 && flag==1;i--) {
            digits[i]++;
            flag = digits[i]/10;
            digits[i] %=10;
        }
        return digits;
    }
}
