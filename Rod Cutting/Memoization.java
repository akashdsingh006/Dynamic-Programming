class Solution{
    public int cutRod(int price[], int n) {
        //code 
        int[][] dp=new int[n][n+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return getRod(n-1,n,price,dp);
    }
    int getRod(int idx,int tar,int price[],int[][] dp)
    {
        if(idx==0)
        {
            //if(tar>=idx+1)
                return tar/(idx+1) *price[idx];
            //else
                //return 0;
        }
        
        if(dp[idx][tar]!=-1)
            return dp[idx][tar];
            
        int notTake=getRod(idx-1,tar,price,dp);
        int take=-(int)1e9;
        int rodLength=idx+1;
        if(rodLength<=tar)
        {
            take=price[idx]+ getRod(idx,tar-rodLength,price,dp);
        }
        return dp[idx][tar]=Math.max(take,notTake);
    }
}
