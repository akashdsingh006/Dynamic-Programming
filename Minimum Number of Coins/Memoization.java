class Solution{

	public int minCoins(int coins[], int n, int tar) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n][tar+1];
	    for(int row[]:dp)
	        Arrays.fill(row,-1);
	    int ans=getNum(n-1,tar,coins,dp);
	    if(ans==(int)1e9)
	        return -1;
	    return ans;
	} 
	public int getNum(int idx,int tar,int[] coins,int[][] dp)
	{
	    if(idx==0)
	    {
	        if(tar%coins[idx]==0)
	            return tar/coins[idx];
	        else
	            return (int)1e9;
	    }
	    if(dp[idx][tar]!=-1)
	        return dp[idx][tar];
	    int notTake=getNum(idx-1,tar,coins,dp);
	    int take=(int)1e9;
	    if(coins[idx]<=tar)
	        take=1+getNum(idx,tar-coins[idx],coins,dp);
	    return dp[idx][tar]=Math.min(take,notTake);
	}
}
