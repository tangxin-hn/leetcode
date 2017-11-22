package p51_p60;

import java.util.Arrays;

public class P53 {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-3};
        P53 t = new P53();
        System.out.println(t.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int tempMax=0;

        for (int i=0;i<nums.length;i++) {
            tempMax += nums[i];
            if (tempMax>max) {
                max = tempMax;
            }
            if (tempMax<0) {
                tempMax = 0;
            }
        }
        return max;
    }
}
