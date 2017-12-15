package p61_p70;

public class P63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
            return 0;
        int[][] matrix=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i=0;i<obstacleGrid.length;i++){
            if (obstacleGrid[i][0]==1)
                break;
            else
                matrix[i][0]=1;
        }
        for (int i=0;i<obstacleGrid[0].length;i++){
            if (obstacleGrid[0][i]==1)
                break;
            else
                matrix[0][i]=1;
        }
        for (int i=1;i<obstacleGrid.length;i++) {
            for (int j=1;j<obstacleGrid[0].length;j++) {
                if (obstacleGrid[i][j]==1)
                    matrix[i][j]=0;
                else
                    matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    //OTHERS
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
