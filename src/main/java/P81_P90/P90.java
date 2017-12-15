package P81_P90;

import java.lang.reflect.Array;
import java.util.*;

public class P90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getSubsetsWithDup(nums,listList,list,0);
        return listList;
    }
    public void getSubsetsWithDup(int[] nums,List<List<Integer>> listList,List<Integer> list,int pos) {
        listList.add(new ArrayList<>(list));
        for (int i=pos;i<nums.length;i++) {
            if (i>0 && i!=pos && nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            getSubsetsWithDup(nums,listList,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
