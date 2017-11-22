package p31_p40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                findSum(candidates, target -candidates[i], i , result, list);
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
                findSum(candidates, target-candidates[i], i, result, list);
                result.remove(result.size()-1);
            }
        }
        return ;
    }
}
