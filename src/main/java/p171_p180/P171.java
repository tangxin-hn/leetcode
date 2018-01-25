package p171_p180;

public class P171 {
    public static void main(String[] args) {
        P171 t = new P171();
        System.out.println(t.titleToNumber("AZ"));
    }
    public int titleToNumber(String s) {
        int sum=0;
        char[] chars=s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            sum = sum * 26 + chars[i] - 'A' + 1;
        }
        return sum;
    }
}
