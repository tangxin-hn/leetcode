package p51_p60;

import java.util.*;

public class P54 {
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        P54 t = new P54();
        System.out.println(t.spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;
        boolean[][] bm = new boolean[matrix.length][matrix[0].length];
        int[] p = {0,0};

        while (p[0]<matrix.length && p[1]<matrix[0].length && !bm[p[0]][p[1]]) {
            so1(list,matrix,bm,p);
            so2(list,matrix,bm,p);
            so3(list,matrix,bm,p);
            so4(list,matrix,bm,p);
        }
        return list;
    }
    public void so1(List<Integer> list, int[][] matrix, boolean[][] bm, int[] p) {
        int i;
        for (i=p[1];i<matrix[p[0]].length;i++) {
            if (bm[p[0]][i])
                break;
            list.add(matrix[p[0]][i]);
            bm[p[0]][i] = true;
        }
        p[0] = p[0]+1;
        p[1] = i-1;
    }

    public void so2(List<Integer> list, int[][] matrix, boolean[][] bm, int[] p) {
        int i;
        for (i=p[0];i<matrix.length;i++) {
            if (bm[i][p[1]])
                break;
            list.add(matrix[i][p[1]]);
            bm[i][p[1]] = true;
        }
        p[1] = p[1]-1;
        p[0] = i-1;
    }

    public void so3(List<Integer> list, int[][] matrix, boolean[][] bm, int[] p) {
        int i;
        for (i=p[1];i>=0;i--) {
            if (bm[p[0]][i])
                break;
            list.add(matrix[p[0]][i]);
            bm[p[0]][i] = true;
        }
        p[0] = p[0]-1;
        p[1] = i+1;
    }

    public void so4(List<Integer> list, int[][] matrix, boolean[][] bm, int[] p) {
        int i;
        for (i=p[0];i>=0;i--) {
            if (bm[i][p[1]])
                break;
            list.add(matrix[i][p[1]]);
            bm[i][p[1]] = true;
        }
        p[1] = p[1]+1;
        p[0] = i+1;
    }

    //others
    public List < Integer > spiralOrder2(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
}
