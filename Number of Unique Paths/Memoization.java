class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return path(a-1,b-1,dp);
    }
     public static int path(int i, int j,int[][]dp)
     {
         if(i==0&&j==0)
            return 1;
        if(i<0||j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=path(i-1,j,dp);
        int left=path(i,j-1,dp);
        return dp[i][j]=up+left;
     }
}
