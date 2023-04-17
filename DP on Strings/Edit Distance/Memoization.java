class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int n=s.length();
        int m=t.length();
        
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return edit(n,m,s,t,dp);
    }
    public int edit(int i,int j,String s,String t,int[][] dp)
    {
        if(i==0)
            return j;
        if(j==0)
            return i;
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        int take=0;
        if(s.charAt(i-1)==t.charAt(j-1))
        {
            return edit(i-1,j-1,s,t,dp);
        }
        else
        {
        int insert=1+edit(i,j-1,s,t,dp);
        int del=1+edit(i-1,j,s,t,dp);
        int rep=1+edit(i-1,j-1,s,t,dp);
        return dp[i][j]=Math.min(insert,Math.min(del,rep));
        }
        //return dp[i][j]=take|notTake;
    }
}
