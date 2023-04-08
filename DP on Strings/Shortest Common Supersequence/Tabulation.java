class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                int notTake=Math.max(dp[i-1][j],dp[i][j-1]);
                int take=0;
                if(X.charAt(i-1)==Y.charAt(j-1))
                {
                    take=1+dp[i-1][j-1];
                }
                dp[i][j]=Math.max(take,notTake);
            }
        }
        return (m+n)-dp[m][n];
    }
}
