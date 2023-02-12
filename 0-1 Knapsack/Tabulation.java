class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp=new int[n][W+1];
         for(int w=wt[0];w<=W;w++)
         {
             if(wt[0]<=W)
                dp[0][w]=val[0];
             else
                dp[0][w]=0;
         }
         for(int i=1;i<n;i++)
         {
             for(int weigh=0;weigh<=W;weigh++)
             {
                 int notTake=dp[i-1][weigh];
                 int take=-(int)1e9;
                 if(wt[i]<=weigh)
                    take=val[i]+dp[i-1][weigh-wt[i]];
                dp[i][weigh]=Math.max(take,notTake);
             }
         }
         return dp[n-1][W];
    } 
}
