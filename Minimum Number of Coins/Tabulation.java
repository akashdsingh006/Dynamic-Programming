class Solution{

	public int minCoins(int coins[], int n, int tar) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n][tar+1];
	    
	    for(int t=0;t<=tar;t++)
	    {
	        if(t%coins[0]==0)
	            dp[0][t]=t/coins[0];
	        else
	            dp[0][t]=(int)1e9;
	    }
	    for(int idx=1;idx<n;idx++)
	    {
	        for(int t=0;t<=tar;t++)
	        {
	             int notTake=dp[idx-1][t];
        	    int take=(int)1e9;
        	    if(coins[idx]<=t)
        	        take=1+dp[idx][t-coins[idx]];
        	    dp[idx][t]=Math.min(take,notTake);
	        }
	    }
	    int ans=dp[n-1][tar];
	    if(ans==(int)1e9)
	        return -1;
	    return ans;
	} 

}
