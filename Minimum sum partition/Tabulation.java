class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int tar=0;
	    for(int i:arr)
	        tar+=i;
	    boolean dp[][]=new boolean[n][tar+1];
	    for(int i=0;i<n;i++)
	    {
	        dp[i][0]=true;
	    }
	    dp[0][arr[0]]=true;
	    for(int idx=1;idx<n;idx++)
	    {
	        for(int target=0;target<=tar;target++)
	        {
	            boolean notTake=dp[idx-1][target];
	            boolean take=false;
	            if(arr[idx]<=target)
	                take=dp[idx-1][target-arr[idx]];
	                
	            dp[idx][target]=take|notTake;
	        }
	    }
	    
	    int mini=(int)1e9;
	    for(int i=0;i<=tar/2;i++)
	    {
	        if(dp[n-1][i]==true)
	        {
	            int s1=i;
	            int s2=tar-s1;
	            mini=Math.min(mini,Math.abs(s1-s2));
	        }
	    }
	    return mini;
	} 
}
