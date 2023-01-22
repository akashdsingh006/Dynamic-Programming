class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer>> grid) {
        // Code here
        int dp[][]=new int[n][n];
        // for(int j=0;j<n-1;j++)
        // {
        //     dp[n-1][j]=grid.get(n-1).get(j);
        // }
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                if(i==n-1)
                {
                    dp[n-1][j]=grid.get(n-1).get(j);
                    continue;
                }
                int down=0,dia=0;
                down=grid.get(i).get(j)+dp[i+1][j];
                dia=grid.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(dia,down);
            }
        }
        return dp[0][0];
    }
}
