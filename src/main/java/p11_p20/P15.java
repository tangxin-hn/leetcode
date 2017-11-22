package p11_p20;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class P15 {
    public static void main(String[] args) {
        int[] nums={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};//{-1, 0, 1, 2, -1, -4};
        P15 t = new P15();
        System.out.println(t.threeSum(nums));
    }
        public List<List<Integer>> threeSum(int[] nums) {
            int flag=0;
            List<List<Integer>> listList = new LinkedList<>();
            List<Integer> l = new LinkedList<>();
            if(nums.length<3)
                return listList;
            for (int i=0;i<nums.length-2;i++) {
                for (int j=i+1;j<nums.length-1;j++) {
                    for (int k=j+1;k<nums.length;k++) {
                        if(nums[i]+nums[j]+nums[k]==0) {
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            if(flag==0 && nums[i]==nums[j] && nums[k]==0) {
                                flag=1;
                                listList.add(l);
                            }

                            int count=0;
                            for(List<Integer> list:listList) {
                                if(list.containsAll(l)){
                                    break;
                                }
                                count++;
                            }
                            if (count==listList.size())
                                listList.add(l);
                            l = new LinkedList<>();
                        }
                    }
                }
            }
            return listList;
        }

    //others
    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
