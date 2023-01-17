class Solution {
    int mod=(int)1e9+7;
    public int totalWays(int n, int m, int grid[][]) {
        // Code here
         if(grid[0][0]==1 || grid[n-1][m-1]==1) return 0;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                if(grid[i][j]==1)
                    continue;
                    
                int up=0,left=0;
                if(i>0)
                up=dp[i-1][j];
                if(j>0)
                left=dp[i][j-1];
                dp[i][j]=(up+left)%mod;
            }
        }
        return dp[n-1][m-1];
    }
    
}
