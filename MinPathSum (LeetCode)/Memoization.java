class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return path(grid,n-1,m-1,dp);
    }
    public int path(int[][] grid,int i,int j,int[][] dp)
    {
        if(i==0&&j==0)
            return grid[0][0];
        if(i<0||j<0)
            return (int)1e9+7;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int up=grid[i][j]+path(grid,i-1,j,dp);
        int left=grid[i][j]+path(grid,i,j-1,dp);
        return dp[i][j]=Math.min(up,left);
    }
}
