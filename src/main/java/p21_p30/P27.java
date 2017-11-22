package p21_p30;

public class P27 {
    public int removeElement(int[] nums, int val) {
        if (nums==null) {
            return 0;
        }
        int pos=0;
        for(int i=0;i<nums.length;i++ ) {
            if(nums[i]!=val) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }
}
