class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[N][sum+1];
        for(long row[]:dp)
            Arrays.fill(row,-1);
        return getCount(N-1,sum,coins,dp);
    }
    long getCount(int idx,int tar,int[]coins,long[][] dp)
    {
        if(idx==0)
        {
            if(tar%coins[idx]==0)
                return 1;
            else    return 0;
        }
        if(dp[idx][tar]!=-1)
            return dp[idx][tar];
        long notTake=getCount(idx-1,tar,coins,dp);
        long take=0;
        if(coins[idx]<=tar)
            take=getCount(idx,tar-coins[idx],coins,dp);
        return dp[idx][tar]=(long)(take+notTake);
    }
}
