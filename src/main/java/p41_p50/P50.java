package p41_p50;

public class P50 {
    public double myPow(double x, int n) {
        long t = (long)n;
        if (n==0)
            return 1;
        if (n<0)
            return 1/myPow2(x,-t);
        return myPow2(x,t);
    }
    public double myPow2(double x, long t) {
        if (t==1)
            return x;
        if (t%2==0) {
            return myPow2(x*x,t/2);
        } else {
            return myPow2(x*x,t/2)*x;
        }
    }

}
