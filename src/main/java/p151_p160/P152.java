package p151_p160;

public class P152 {
    public int maxProduct(int[] nums) {
        int r=nums[0];
        for (int i=1,imax=r,imin=r;i<nums.length;i++) {
            if (nums[i]<0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(nums[i],nums[i]*imax);
            imin = Math.min(nums[i],nums[i]*imin);
            if (imax>r)
                r = imax;
        }
        return r;
    }
}
