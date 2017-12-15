package P91_P100;

public class P96 {
    public static void main(String[] args) {
        P96 t = new P96();
        System.out.println(t.numTrees2(3));
    }

    //递归，超时
    public int numTrees(int n) {
        if (n<1)
            return 0;
        return getTrees(1,n);
    }
    public int getTrees(int start,int end) {
        int count = 0;
        if (start>=end)
            return 1;
        else{
            for (int i=start;i<=end;i++) {
                int left=getTrees(start,i-1);
                int right=getTrees(i+1,end);
                count += left*right;
            }
        }
        return count;
    }

    //非递归
    public int numTrees2(int n) {
        if (n<1)
            return 0;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i=2;i<=n;i++) {
            for (int j=0;j<i;j++)
                nums[i] += nums[j]*nums[i-j-1];
        }
        return nums[n];
    }
}
