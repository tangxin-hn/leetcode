package p11_p20;

import java.util.Arrays;

public class P16 {
    public static void main(String[] args) {
        int[] nums={-1,0,1,1,55};
        P16 t = new P16();
        System.out.println(t.threeSumClosest(nums, 3));
    }
    public int threeSumClosest(int[] nums, int target) {
        int closest=Integer.MAX_VALUE;
        int closestSum=target;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if ((int) Math.abs(target - sum) < closest) {
                        closest = (int) Math.abs(target - sum);
                        closestSum = sum;
                    }
                    if (target - sum > 0) l++;
                    if (target - sum < 0) r--;
                    if (target == sum) return target;
                }
            }
        }
        return closestSum;
    }
}
