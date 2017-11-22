package p31_p40;

public class P33 {
    public static void main(String[] args) {
        int[] nums = {4};
        P33 t = new P33();
        System.out.println(t.search(nums,4));
    }
    public int search(int[] nums, int target) {
        if (nums==null)
            return -1;
        if (nums.length==0)
            return -1;

        int start=0, length=nums.length;
        if (nums[0]>nums[length-1]) {
            int l = 0, r = length, m=-1;
            while ( (l < r) && (m!=(l + r) / 2) ) {
                m = (l + r) / 2;
                if (nums[m]<nums[l]) {
                    r = m;
                } else {
                    l = m;
                }
            }
            start = r;
        }

        int l = start, r = start + length, m=-1;
        while ( (l < r) && (m!=(l+r)/2) ) {
            m = (l + r) / 2;
            if (nums[m%length]==target) {
                return m%length;
            } else if (nums[m%length]>target) {
                r = m;
            } else {
                l = m;
            }
        }
        return -1;
    }



    //others
    public int search2(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < nums[end]) {
                if (target >= nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }
            else {
                if (target <= nums[mid] && target >= nums[start]) end = mid;
                else start = mid;
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
