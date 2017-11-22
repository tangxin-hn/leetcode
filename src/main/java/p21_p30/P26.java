package p21_p30;

import java.util.Arrays;

public class P26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0)
            return 0;
        int count=1;
        int pos=1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[i-1]) {
                count++;
                nums[pos]=nums[i];
                pos++;
            }
        }
        return count;
    }
}
