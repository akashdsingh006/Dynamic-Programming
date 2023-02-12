class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[]prev=new int[W+1];
         
         for(int w=wt[0];w<=W;w++)
         {
             if(wt[0]<=W)
                prev[w]=val[0];
             else
                prev[w]=0;
         }
         for(int i=1;i<n;i++)
         {  int[]curr=new int[W+1];
             for(int weigh=0;weigh<=W;weigh++)
             {
                 int notTake=prev[weigh];
                 int take=-(int)1e9;
                 if(wt[i]<=weigh)
                    take=val[i]+prev[weigh-wt[i]];
                curr[weigh]=Math.max(take,notTake);
             }
             prev=curr;
         }
         return prev[W];
    } 
}
