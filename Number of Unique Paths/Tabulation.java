class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        
        dp[0][0]=1;
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<b;j++)
            {
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i-1>=0)
                    up=dp[i-1][j];
                if(j-1>=0)
                    left=dp[i][j-1];
                    
                    dp[i][j]=up+left;
                
            }
        }
        return dp[a-1][b-1];
    }
}
