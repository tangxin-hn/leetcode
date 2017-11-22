package p41_p50;

public class P48 {
    public void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=i+1;j<matrix[i].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1] = temp;
            }
        }
    }
}
