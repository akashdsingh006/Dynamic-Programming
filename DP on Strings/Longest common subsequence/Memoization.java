 Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x+1][y+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return getLCS(x,y,s1,s2,dp);
    }
    static int getLCS(int idx1,int idx2,String s1,String s2,int[][]dp)
    {
        if(idx1==0||idx2==0)
        {
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
            return dp[idx1][idx2];
            
            
        if(s1.charAt(idx1-1)==s2.charAt(idx2-1))
        {
            return 1+getLCS(idx1-1,idx2-1,s1,s2,dp);
        }
        
        return dp[idx1][idx2]=Math.max(getLCS(idx1-1,idx2,s1,s2,dp),getLCS(idx1,idx2-1,s1,s2,dp));
    }
}
