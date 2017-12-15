package P71_p80;

public class P75 {
    public static void main(String[] args) {
        P75 t = new P75();
        int[] nums = {2,0,1,2,2,1,0};
        t.sortColors(nums);
        for (int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
    }

    //错误，解不出
    public void sortColors(int[] nums) {
        if (nums==null || nums.length==0 ||nums.length==1)
            return;
        int l=0,r=nums.length-1;
        while (l<=r && nums[l]==0)
            l++;
        int p0=l;
        while (l<=r && nums[l]==1)
            l++;
        int p1=l;
        if (p0==0 && p1==0)
            l++;
        while (l<r) {
            while (l<=r && nums[l]==nums[l-1])
                l++;
            while (l<=r && nums[r]==2)
                r--;
            if (l>r)
                break;
            if (nums[l]>nums[r]) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
            if (nums[l]<nums[p0]) {
                int t = nums[l];
                nums[l] = nums[p0];
                nums[p0] = t;
                if (nums[p0]==0)
                    p0++;
            }
        }
    }

    //others
    public void sortColors2(int[] A) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }
}
