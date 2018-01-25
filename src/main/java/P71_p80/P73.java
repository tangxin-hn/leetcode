package p71_p80;

public class P73 {
    public static void main(String[] args) {
        P73 t = new P73();
        int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        t.setZeroes2(matrix);
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        int row  = -1;
        int column  = -1;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j]==0) {
                    if(row<0) {
                        row = i;
                        column = j;
                    } else {
                        matrix[row][j] = 0;
                        matrix[i][column] = 0;
                    }
                }
            }
        }
        if (row==-1)
            return;
        for (int i=0;i<matrix.length;i++) {
            if (matrix[i][column]==0 && i!=row) {
                for (int j=0;j<matrix[0].length;j++)
                    matrix[i][j] = 0;
            }
        }
        for (int i=0;i<matrix[0].length;i++) {
            if (matrix[row][i]==0 && i!=column) {
                for (int j=0;j<matrix.length;j++)
                    matrix[j][i] = 0;
            }
        }
        for (int i=0;i<matrix.length;i++)
            matrix[i][column]=0;
        for (int i=0;i<matrix[0].length;i++)
            matrix[row][i]=0;
    }

    //others
    void setZeroes2(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
