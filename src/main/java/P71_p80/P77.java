package P71_p80;

import java.util.*;

public class P77 {
    public static void main(String[] args) {
        P77 t = new P77();
        System.out.println(t.combine(4,2));
    }
    public List<List<Integer>> combine(int n, int k) {
        HashSet<HashSet<Integer>> hashSets = new HashSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        myCombine(hashSets,hashSet,n,k);

        List<List<Integer>> listList = new ArrayList<>();
        for (HashSet<Integer> t:hashSets) {
            List<Integer> tempList = new ArrayList<>();
            for (int i:t)
                tempList.add(i);
            listList.add(tempList);
        }

        return listList;
    }
    public static void myCombine(HashSet<HashSet<Integer>> hashSets,HashSet<Integer> hashSet,int n, int k){
        if (hashSet.size()==k && !hashSets.contains(hashSet)) {
            HashSet<Integer> temp = new HashSet<>(hashSet);
            hashSets.add(temp);
            return;
        }
        for (int i=1;i<=n;i++) {
            if (hashSet.contains(i))
                continue;
            hashSet.add(i);
            myCombine(hashSets,hashSet,n,k);
            hashSet.remove(i);
        }
    }

    //others
    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
