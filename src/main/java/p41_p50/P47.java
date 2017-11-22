package p41_p50;

import java.util.*;

public class P47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        P47 t = new P47();
        System.out.println(t.permuteUnique2(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists,nums,new ArrayList<Integer>());
        return lists;
    }
    public void backtrack(List<List<Integer>> lists, int[] nums, List<Integer> tempList) {
        if (tempList.size()==nums.length) {
            if (!lists.contains(tempList)) {
                lists.add(new ArrayList<Integer>(tempList));
            }
        } else {
            for (int i=0;i<nums.length;i++) {
                int count=0;
                for (int tempNum:tempList) {
                    if (tempNum==nums[i])
                        count++;
                }
                int count2=0;
                for (int tempNum:nums) {
                    if (tempNum==nums[i])
                        count2++;
                }
                if (count==count2)
                    continue;
                tempList.add(nums[i]);
                backtrack(lists,nums,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    //others
    public List<List<Integer>> permuteUnique2   (int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            //if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
