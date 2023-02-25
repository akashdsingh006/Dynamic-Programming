class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int[N][W+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return unboundedKnapSack(N-1,W,wt,val,dp);
    }
    static int unboundedKnapSack(int idx,int tar,int[] wt,int[] val,int dp[][])
    {
        if(idx==0)
        {
            return val[idx]*(tar/wt[idx]);
        }
        if(dp[idx][tar]!=-1)
            return dp[idx][tar];
        int notTake=unboundedKnapSack(idx-1,tar,wt,val,dp);
        int take=-(int)1e9;
        if(wt[idx]<=tar)
            take=val[idx]+unboundedKnapSack(idx,tar-wt[idx],wt,val,dp);
        return dp[idx][tar]=Math.max(take,notTake);
    }
}
