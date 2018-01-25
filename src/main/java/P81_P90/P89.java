package p81_p90;

import java.util.*;

public class P89 {
    public static void main(String[] args) {
        P89 t = new P89();
        System.out.println(t.grayCode(7));
    }
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int t=0;
        int num = (int)Math.pow(2,n);
        while (list.size()<num){
            for (int j=0;j<n;j++) {
                t ^= (int)Math.pow(2,j);
                if (!list.contains(t)) {
                    list.add(t);
                    break;
                } else {
                    t ^= (int)Math.pow(2,j);
                }
             }
        }
        return list;
    }

    //others
    public List<Integer> grayCode2(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);
        }
        return rs;
    }
    public List<Integer> grayCode3(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
