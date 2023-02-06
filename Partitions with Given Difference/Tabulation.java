class Solution{
    int mod=(int)1e9+7;
    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int sum=0;
        for(int i:arr)
            sum+=i;
        if(sum-d<0 || (sum-d)%2!=0)
            return 0;
            
        int s2=(sum-d)/2;
        int dp[][]=new int[n][s2+1];
        return count(s2,arr,dp);
    }
    int count(int tar,int[] arr,int[][]dp)
    {
        int n=arr.length;
        if(arr[0]==0)   
            dp[0][0]=2;
        else        
            dp[0][0]=1;
        
        if(arr[0]!=0 && arr[0]<=tar)
            dp[0][arr[0]]=1;
            
        for(int i=1;i<n;i++)
        {
            for(int target=0;target<=tar;target++)
            {
                int notTake=dp[i-1][target];
                int take=0;
                if(arr[i]<=target)
                    take=dp[i-1][target-arr[i]];
                dp[i][target]=(take+notTake)%mod;
            }
        }
        return dp[n-1][tar];
    }
}
