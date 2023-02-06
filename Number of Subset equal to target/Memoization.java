

class Solution{
    int mod=(int)1e9+7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    int dp[][]=new int[n][sum+1];
	    for(int row[]:dp)
	        Arrays.fill(row,-1);
	    return count(n-1,sum,arr,dp);
	} 
	public int count(int idx,int target,int[] arr,int dp[][])
	{
	    if(idx==0)
	    {
	        if(target==0 && arr[idx]==0) return 2;
	        if(target==0 || arr[idx]==target) return 1;
	        return 0;
	    }
	        
	    if(dp[idx][target]!=-1)
	        return dp[idx][target];
	        
	    int notTake=count(idx-1,target,arr,dp);
	    int take=0;
	    if(arr[idx]<=target)
	        take=count(idx-1,target-arr[idx],arr,dp);
	    return dp[idx][target]=(take+notTake)%mod;
	}
}
