
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp=new int[n][W+1];
         for(int row[]:dp)
            Arrays.fill(row,-1);
         
         return steal(n-1,W,wt,val,dp);
    } 
    static int steal(int idx,int W,int[] wt,int[] val,int[][] dp)
    {
        if(idx==0)
        {
            if(wt[idx]<=W)
                return val[idx];
            else
                return 0;
        }
        if(dp[idx][W]!=-1)
            return dp[idx][W];
        int notTake=steal(idx-1,W,wt,val,dp);
        int take=Integer.MIN_VALUE;
        if(wt[idx]<=W)
            take=val[idx]+steal(idx-1,W-wt[idx],wt,val,dp);
        return dp[idx][W]=Math.max(take,notTake);
    }
}

