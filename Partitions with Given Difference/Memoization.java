class Solution{

    public int countPartitions(int n, int d, int arr[]){
        // Code here
        int sum=0;
        for(int i:arr)
            sum+=i;
        if(sum-d<0 || (sum-d)%2!=0)
            return 0;
            
        
        int s2=(sum-d)/2;
        int dp[][]=new int[n][s2+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return count(n-1,s2,arr,dp);
    }
    int count(int idx,int tar,int[] arr,int[][]dp)
    {
        if(idx==0)
        {
            if(arr[0]==0&& tar==0)  return 2;
            if(arr[0]==tar || tar==0)    return 1;
            return 0;
        }
        if(dp[idx][tar]!=-1)
            return dp[idx][tar];
        int notTake=count(idx-1,tar,arr,dp);
        int take=0;
        if(arr[idx]<=tar)
            take=count(idx-1,tar-arr[idx],arr,dp);
        return dp[idx][tar]=(take+notTake)%(int)(1e9+7);
    }
}
