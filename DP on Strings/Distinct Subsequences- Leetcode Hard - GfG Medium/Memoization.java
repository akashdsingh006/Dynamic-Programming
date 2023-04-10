class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return generateDistinct(n,m,s,t,dp);
    }
    private int generateDistinct(int i,int j,String s,String t,int[][] dp)
    {
        if(j==0)
            return 1;
        if(i==0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int notTake=0;
        int take=0;
        if(s.charAt(i-1)==t.charAt(j-1))
        {
            take=generateDistinct(i-1,j-1,s,t,dp)+generateDistinct(i-1,j,s,t,dp);
        }
        else
        {
            notTake=generateDistinct(i-1,j,s,t,dp);
        }
        return dp[i][j]=take+notTake;
    }
}
