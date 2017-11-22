package p31_p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P40 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,5,6};
        P40 t = new P40();
        System.out.println(t.combinationSum2(nums,5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();

        if (candidates.length==0)
            return list;
        Arrays.sort(candidates);
        if (target<candidates[0])
            return list;

        for(int i=candidates.length-1;i>=0;i--) {
            if (candidates[i]<=target) {
                List<Integer> result = new LinkedList<>();
                result.add(candidates[i]);
                findSum(candidates, target -candidates[i], i-1, result, list);
                result.remove(result.size()-1);
            }
        }

        return list;
    }

    public void findSum(int[] candidates, int target, int end, List result, List list) {
        if (target==0) {
            if (!list.contains(result))
                list.add(new LinkedList<Integer>(result));
            return ;
        }
        if (target<candidates[0])
            return ;
        for (int i=end;i>=0;i--) {
            if (candidates[i]<=target) {
                result.add(candidates[i]);
                findSum(candidates, target-candidates[i], i-1, result, list);
                result.remove(result.size()-1);
            }
        }
        return ;
    }

    //others
    public List<List<Integer>> combinationSum22(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), cand[i]);
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }
}
