package p151_p160;

public class P153 {
    public static void main(String[] args) {
        P153 t = new P153();
        int[] nums={1,2,3,4,0};
        System.out.println(t.findMin(nums));
    }
    public int findMin(int[] nums) {
        if (nums==null)
            return 0;
        int l=0,r=nums.length-1;
        while (l<r){
            int m = (l+r)/2;
            if (nums[m]<nums[l]) {
                r = m;
            }else if (nums[m]>nums[r]) {
                l = m+1;
            } else {
                return nums[l];
            }
        }
        return nums[l];
    }
}
