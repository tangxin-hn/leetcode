package p111_p120;

import java.util.List;

public class P120 {
    //动态规划,无需额外空间，改变数据
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()<1)
            return 0;
        for (int i=triangle.size()-2;i>=0;i--) {
            for (int j=0;j<triangle.get(i).size();j++) {
                int temp = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,triangle.get(i).get(j)+temp);
            }
        }
        return triangle.get(0).get(0);
    }

    //动态规划,需额外空间，不改变数据
    public int minimumTotal3(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    //递归，超时
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()<1)
            return 0;
        return minimumTotal(triangle,0,0);
    }
    public int minimumTotal(List<List<Integer>> triangle,int deepth,int pos) {
        if (deepth==triangle.size()-1)
            return triangle.get(deepth).get(pos);
        return  Math.min(minimumTotal(triangle,deepth+1,pos),minimumTotal(triangle,deepth+1,pos+1)) + triangle.get(deepth).get(pos);
    }
}
