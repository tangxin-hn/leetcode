package p71_p80;

import java.util.ArrayList;
import java.util.List;

public class P78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSet = new ArrayList<List<Integer>>();
        subSet.add(new ArrayList<>());
        for (int i=1;i<=nums.length;i++) {
            List<Integer> sub = new ArrayList<>();
            combine(subSet,sub,nums,0,i);
        }
        return subSet;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int[] nums, int start, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=nums.length;i++) {
            comb.add(nums[i]);
            combine(combs, comb, nums,i+1,k-1);
            comb.remove(comb.size()-1);
        }
    }
}
