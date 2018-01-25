package p171_p180;

public class P172 {
    public static void main(String[] args) {
        P172 t = new P172();
        System.out.println(t.trailingZeroes(11));
    }
    public int trailingZeroes(int n) {
        int count=0;
        while (n>0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
