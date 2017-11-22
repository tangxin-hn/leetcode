package p31_p40;

public class P35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        P35 t = new P35();
        System.out.println(t.searchInsert(nums,0));
    }
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0)
            return 0;

        int l=0,r=nums.length,m=-1;
        if (nums[0]>=target)
            return 0;
        if (nums[r-1]<target)
            return r;

        while (l<r-1 && m!=(l+r)/2) {
            m = (l+r)/2;
            if (nums[m]==target)
                return m;
            if (nums[m]>target) {
                r = m;
            } else {
                l = m;
            }
        }
        return l+1;
    }

    //others
    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
