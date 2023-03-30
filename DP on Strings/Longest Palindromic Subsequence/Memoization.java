class Solution
{
    public int longestPalinSubseq(String s1)
    {
        //code here
        StringBuilder str=new StringBuilder(s1);
        String s2=str.reverse().toString();
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        
        for(int r[]:dp)
            Arrays.fill(r,-1);
        return getPalin(s1.length(),s2.length(),s1,s2,dp);
    }
    public int getPalin(int i,int j,String s1,String s2,int[][]dp)
    {
        if(i==0||j==0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int notTake=Math.max(getPalin(i,j-1,s1,s2,dp),getPalin(i-1,j,s1,s2,dp));
        int take=0;
        if(s1.charAt(i-1)==s2.charAt(j-1))
            take=1+getPalin(i-1,j-1,s1,s2,dp);
        return dp[i][j]=Math.max(take,notTake);
        
    }
}
