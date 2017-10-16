package p1_p10;

public class P9 {
    public static void main(String[] args) {
        P9 t = new P9();
        System.out.println(t.isPalindrome(-2147483648));
    }
    public boolean isPalindrome(int x) {
        long t = x;
        if(t<0) {
            return false;
        }

        long tr = reverse(t);
        while(t>0) {
            if(t%10 != tr%10) {
                return false;
            }
            t /=10;
            tr /= 10;
        }
        return true;
    }
    public long reverse(long x)
    {
        long result = 0;

        while (x != 0)
        {
            long tail = x % 10;
            long newResult = result * 10 + tail;
            result = newResult;
            x = x / 10;
        }
        return result;
    }


    //others
    public boolean IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
