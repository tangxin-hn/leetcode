package P71_p80;

public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int l=0,row=matrix.length,column=matrix[0].length,r = row*column-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if (matrix[mid/column][mid%column]==target)
                return true;
            else if (matrix[mid/column][mid%column]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return false;
    }
}
