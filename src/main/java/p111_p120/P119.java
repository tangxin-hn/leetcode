package p111_p120;

import java.util.*;

public class P119 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        if (rowIndex<=0)
            return new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        List<Integer> preNum = new ArrayList<>();
        num.add(1);
        preNum.add(1);
        for (int i=2;i<=rowIndex;i++) {
            for (int j=1;j<i;j++) {
                if (j==i-1) {
                    num.add(1);
                    preNum = num;
                    num = new ArrayList<>();
                    num.add(1);
                }
                else
                    num.add(preNum.get(j-1) + preNum.get(j));
            }
        }
        return preNum;
    }

    //others
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
}
