class Solution {
    int mod=(int)1e9+7;
    public int totalWays(int n, int m, int grid[][]) {
        // Code here
         if(grid[0][0]==1 || grid[n-1][m-1]==1) return 0;
        int dp[][]=new int[n][m];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        
        return find(grid,n-1,m-1,dp);
    }
    public int find(int grid[][],int i,int j,int[][]dp)
    {
        if(i==0&&j==0)
            return 1;
        if(i<0||j<0)
            return 0;
        if(i>=0&&j>=0&&grid[i][j]==1)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int up=find(grid,i-1,j,dp);
        int left=find(grid,i,j-1,dp);
        return dp[i][j]=(up+left)%mod;
    }
}
