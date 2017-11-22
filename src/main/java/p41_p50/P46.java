package p41_p50;

import java.util.*;

public class P46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        P46 t = new P46();
        System.out.println(t.permute2(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> linkedList = new LinkedList<>();
        if (nums.length==0)
            return linkedList;
        for (int i=0;i<nums.length;i++) {
            List<Integer> linkedList2 = new LinkedList<>();
            linkedList2.add(nums[i]);
            linkedList.add(linkedList2);
        }
        while (linkedList.get(0).size()!=nums.length) {
            List<Integer> linkedList2 = linkedList.remove(0);
            for (int i=0;i<nums.length;i++) {
                if (!linkedList2.contains(nums[i])) {
                    List<Integer> linkedList3 = new LinkedList<>(linkedList2);
                    linkedList3.add(nums[i]);
                    linkedList.add(linkedList3);
                }
            }
        }
        return linkedList;
    }

    //others
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
