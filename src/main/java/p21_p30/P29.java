package p21_p30;

public class P29 {
    public static void main(String[] args) {
        //String s = "{{)}";
        P29 t = new P29();
        System.out.println(t.divide2(-2147483648,-1));
    }
    public int divide(int dividend, int divisor) {
        if (divisor==0) System.exit(1);
        if(dividend==0) {return 0;}
        int flag=0;
        if (dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        if (dividend>0) {
            flag++;
            dividend = 0-dividend;
        }
        if (divisor>0) {
            flag++;
            divisor = 0-divisor;
        }
        int count=-1;
        for(count=-1;dividend<=0;dividend = dividend-divisor,count++);
        if(flag==1)
            return 0-count;
        return count;
    }

    //others
    public int divide2(int dividend, int divisor) {
        if (divisor==0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = (long)Math.abs((long)dividend);
       long dvs = (long)Math.abs((long)divisor);
        int res = 0;
        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }
}
