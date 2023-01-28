class Solution{


    static Boolean isSubsetSum(int n, int arr[], int target){
        // code here
        boolean dp[][]=new boolean[n+1][target+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        dp[0][arr[0]]=true;
        for(int i=1;i<n;i++)
        {
            for(int t=1;t<=target;t++)
            {
                boolean notTake=dp[i-1][t];
                boolean take=false;
                if(arr[i]<=t)
                    take=dp[i-1][t-arr[i]];
                dp[i][t]=take|notTake;
            }
        }
        return dp[n-1][target];
    }
    
}
