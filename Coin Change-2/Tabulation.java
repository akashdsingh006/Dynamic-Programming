class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[N][sum+1];
        for(int s=0;s<=sum;s++)
        {
            if(s%coins[0]==0)
                dp[0][s]=1;
            else
                dp[0][s]=0;
        }
        
        for(int idx=1;idx<N;idx++)
        {
            for(int tar=0;tar<=sum;tar++)
            {
                long notTake=dp[idx-1][tar];
                long take=0;
                if(coins[idx]<=tar)
                    take=dp[idx][tar-coins[idx]];
                dp[idx][tar]=take+notTake;
            }
        }
        return dp[N-1][sum];
    }
}
