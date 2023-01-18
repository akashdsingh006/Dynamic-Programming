class Solution{
    static int maximumPath(int n, int matrix[][])
    {
        // code here
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
            
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,maxPath(matrix,n-1,i,dp));
        }
        return max;
    }
    static int maxPath(int matrix[][],int i,int j,int[][] dp)
    {
        if(i==0 )
            return matrix[i][j];
        
        if(j<0||j>matrix.length||i<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int up=0,leftd=0,rightd=0;
        up=matrix[i][j]+maxPath(matrix,i-1,j,dp);
        
        if(i-1>=0 &&j-1>=0)
        leftd=matrix[i][j]+maxPath(matrix,i-1,j-1,dp);
        
        if(i-1>=0 &&j+1<matrix.length)
        rightd=matrix[i][j]+maxPath(matrix,i-1,j+1,dp);
        
        return dp[i][j]=Math.max(up,Math.max(leftd,rightd));
    }
}
