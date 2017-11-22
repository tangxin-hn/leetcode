package p51_p60;

import java.util.*;

public class P59 {
    public int[][] generateMatrix(int n) {
        int count=1;
        int[][] matrix = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++,count++)
                matrix[r1][c] = count;
            for (int r = r1 + 1; r <= r2; r++,count++)
                matrix[r][c2] = count;
            for (int c = c2 - 1; c > c1; c--,count++)
                matrix[r2][c] = count;
            for (int r = r2; r > r1; r--,count++)
                matrix[r][c1]=count;
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return matrix;
    }
}
