package p31_p40;

public class P34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        P34 t = new P34();
        int[] range = t.searchRange(nums,5);
        System.out.println(range[0] + "  " + range[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int [] range = {-1,-1};
        if (nums.length==0)
            return range;

        int pos=-1;
        int l = 0, r = nums.length, m=-1;
        while ( (l < r) && (m!=(l+r)/2) ) {
            m = (l + r) / 2;
            if (nums[m]==target) {
                pos = m;
                break;
            } else if (nums[m]>target) {
                r = m;
            } else {
                l = m;
            }
        }

        if (pos==-1)
            return range;

        l = 0;
        r = pos;
        m=-1;
        while ( (l < r) && (m!=(l+r)/2) ) {
            m = (l + r) / 2;
            if (nums[m]!=target) {
                l = m;
            }  else {
                r = m;
            }
        }
        range[0] = r;

        l = pos;
        r = nums.length;
        m=-1;
        while ( (l < r) && (m!=(l+r)/2) ) {
            m = (l + r) / 2;
            if (nums[m]!=target) {
                r = m;
            }  else {
                l = m;
            }
        }
        range[1] = l;

        return range;
    }


    //others
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result=new int[2];
            result[0]=frist(nums,target);
            result[1]=two(nums,target);
            return result;
        }
        public  int frist(int[] nums,int target){
            int min=0;
            int idx=-1;
            int max=nums.length-1;
            while (min<=max)
            {
                int mid=(min+max)/2;
                if(nums[mid]>=target)
                {
                    max=mid-1;
                }else {
                    min=mid+1;
                }
                if(nums[mid]==target)
                    idx=mid;
            }
            return idx;
        }

        public  int two(int[] nums,int target){
            int min=0;
            int idx=-1;
            int max=nums.length-1;
            while (min<=max)
            {
                int mid=(min+max)/2;
                if(nums[mid]<=target)
                {
                    min=mid+1;
                }else {
                    max=mid-1;
                }
                if(nums[mid]==target)
                    idx=mid;
            }

            return idx;
        }
    }
}
