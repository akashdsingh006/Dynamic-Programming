class Solution{


    static Boolean isSubsetSum(int n, int arr[], int target){
        // code here
        int dp[][]=new int[n+1][target+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return subset(n-1,target,arr,dp);
    }
    static boolean subset(int idx,int target,int[] arr,int[][] dp)
    {
        if(target==0)
            return true;
        if(idx==0)
            return (arr[idx]==target);
            
        if(dp[idx][target]!=-1)
            return dp[idx][target]==0?false:true;
            
        boolean not_take=subset(idx-1,target,arr,dp);
        boolean take=false;
        if(target>=arr[idx])
            take=subset(idx-1,target-arr[idx],arr,dp);
        dp[idx][target]=not_take||take?1:0;
        return take||not_take;
    }
}
