package p51_p60;

public class P55 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        P55 t = new P55();
        System.out.println(t.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        boolean[] b = new boolean[nums.length];
        return isJump(nums, b, nums.length-1);
    }
    public boolean isJump(int[] nums, boolean[] b, int end) {
        if (end<=nums[0])
            return true;
        for(int i=end-1;i>=0;i--) {
            if (!b[i] && nums[i]>=end-i) {
                if (isJump(nums, b, i))
                    return true;
                else
                    b[i]=true;
            }
        }
        return false;
    }

    //others
    public boolean canJump2(int[] nums) {
        int lastpos=nums.length-1;
        for (int i=nums.length-2;i>=0;i--) {
            if (i + nums[i]>=lastpos)
                lastpos = i;
        }
        return lastpos==0;
    }
}
