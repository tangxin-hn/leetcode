package p161_p170;

public class P162 {
    public int findPeakElement(int[] nums) {
        if (nums==null)
            return -1;
        if (nums.length==1 || nums[0]>nums[1])
            return 0;
        if (nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        for (int i=1;i<nums.length - 1;i++) {
            if (nums[i]>nums[i-1] && nums[i]>nums[i+1])
                return i;
        }
        return -1;
    }

    //others
    public class Solution {
        public int findPeakElement(int[] nums) {
            return search(nums, 0, nums.length - 1);
        }
        public int search(int[] nums, int l, int r) {
            if (l == r)
                return l;
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                return search(nums, l, mid);
            return search(nums, mid + 1, r);
        }
    }
}
