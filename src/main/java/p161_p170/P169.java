package p161_p170;

public class P169 {
    public int majorityElement(int[] nums) {
        int pos=0;
        int count=1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]==nums[pos])
                count++;
            else
                count--;
            if (count<0) {
                count=1;
                pos = i;
            }
        }
        return nums[pos];
    }
}
