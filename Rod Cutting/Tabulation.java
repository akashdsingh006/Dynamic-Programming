class Solution{
    public int cutRod(int price[], int n) {
        //code 
        int[][] dp=new int[n][n+1];
        for(int i=0;i<=n;i++)
        {
            //int j=i+1;
            dp[0][i]=i* price[0];
        }
        
        for(int idx=1;idx<n;idx++)
        {
            for(int tar=0;tar<=n;tar++)
            {
                int notTake=dp[idx-1][tar];
                int take=-(int)1e9;
                int rodLength=idx+1;
                
                if(rodLength<=tar)
                    take=price[idx]+dp[idx][tar-rodLength];
                dp[idx][tar]=Math.max(take,notTake);
            }
        }
        return dp[n-1][n];
    }
        
}
