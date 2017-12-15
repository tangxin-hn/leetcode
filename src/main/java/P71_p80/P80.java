package P71_p80;

public class P80 {
    public static void main(String[] args) {
        P80 t = new P80();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(t.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int count=1;
        boolean flag = false;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]==nums[i-1]) {
                if (!flag) {
                    nums[count]=nums[i];
                    flag = true;
                    count++;
                }
            } else {
                nums[count]=nums[i];
                count++;
                flag=false;
            }
        }
        return count;
    }
}
