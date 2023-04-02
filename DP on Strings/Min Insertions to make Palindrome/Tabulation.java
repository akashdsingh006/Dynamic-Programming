
class Solution{
    static int countMin(String str1)
    {
        // code here
        int n=str1.length();
        StringBuilder st=new StringBuilder(str1);
        String str2=st.reverse().toString();
        // Finding longest palindromic subsequence
        
        int dp[][]=new int[n+1][n+1]; //1-based indexing
        for(int i=0;i<n+1;i++)
        {
            dp[0][i]=0;
            dp[i][0]=0;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                int notTake=Math.max(dp[i][j-1],dp[i-1][j]);
                int take=0;
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    take=1+dp[i-1][j-1];
                dp[i][j]=Math.max(take,notTake);
            }
        }
        return n-dp[n][n];
    }
}
