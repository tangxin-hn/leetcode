package p111_p120;

import java.util.*;

public class P118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>();
        if (numRows<=0)
            return listList;
        List<Integer> list = new ArrayList<>();
        List<Integer> preList = null;
        for (int i=1;i<=numRows;i++) {
            for (int j=0;j<i;j++) {
                if (j==i-1) {
                    list.add(1);
                    listList.add(list);
                    preList = list;
                    list = new ArrayList<>();
                } else if (j==0) {
                    list.add(1);
                } else {
                    list.add(preList.get(j-1)+preList.get(j));
                }
            }
        }
        return listList;
    }

    //others
    public List<List<Integer>> generate2(int numRows) {
        int[][] lists = new int[numRows][];  //每一行大小不一样
        int[] pre = null;

        for (int i = 0; i < numRows; i++) {
            int[] list = new int[i+1];
            list[0]=1;
            if (pre == null) {
                lists[i] = list;
                pre = list;
                continue;
            }
            for (int i1 = 1; i1 <= i; i1++) {
                int size = pre.length;

                if (i1+1 <=size) {
                    list[i1]=pre[i1]+pre[i1-1];
                } else{
                    list[i1] = 1;
                }

            }
            lists[i] = list;
            pre = list;

        }

        return (List)Arrays.asList(lists); //数组直接装list
    }
}
