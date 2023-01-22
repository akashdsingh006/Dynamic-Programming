class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer>> grid) {
        // Code here
        int dp[][]=new int[n][n];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return minSum(grid,0,0,dp);
    }
    static int minSum(ArrayList<ArrayList<Integer>> grid,int i,int j, int[][]dp)
    {
        if(i==grid.size()-1)
            return grid.get(grid.size()-1).get(j);
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        int down=0,dia=0;
        down=grid.get(i).get(j)+minSum(grid,i+1,j,dp);
        dia=grid.get(i).get(j)+minSum(grid,i+1,j+1,dp);
        return dp[i][j]=Math.min(down,dia);
    }
}
