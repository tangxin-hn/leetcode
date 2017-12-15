package p61_p70;

public class P62 {
    public static void main(String[] args) {
        P62 t = new P62();
        System.out.println(t.uniquePaths2(3,7));
    }

    public int uniquePaths(int m, int n) {
        if (m<1 || n<1)
            return 0;
        int x=1,y=1;
        return findRoad(x,y,m,n);
    }
    public int findRoad(int x, int y,int m,int n) {
        if (x==m && y==n) {
            return 1;
        }
        int t1=0,t2=0;
        if (x<m)
            t1 = findRoad(x+1,y,m,n);
        if (y<n)
            t2 = findRoad(x,y+1,m,n);
        return t1+t2;
    }

    public int uniquePaths2(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i=0;i<m;i++)
            matrix[i][0]=1;
        for (int i=0;i<n;i++)
            matrix[0][i]=1;
        for (int i=1;i<m;i++)
            for (int j=1;j<n;j++)
                matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
        return matrix[m-1][n-1];
    }

    public int uniquePaths3(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }
}
