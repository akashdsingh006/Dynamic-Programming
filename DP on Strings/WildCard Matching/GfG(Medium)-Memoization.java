//GFG SOLUTION
//GFG SOLUTION
//GFG SOLUTION
//GFG SOLUTION
//GFG SOLUTION


class Solution
{
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        
       int n=pattern.length();
        int m=str.length();
        
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
            
        return search(n,m,pattern,str,dp);
        
    }
    int search(int i,int j,String pat,String str,int [][] dp)
    {
        if(i==0 && j==0)    return 1;
        if(i==0 && j>0)     return 0;
        
        if(j==0 && i>0)
        {
            for(int ii=0;ii<i;ii++)
            {
                if(pat.charAt(ii)!='*')
                    return 0;
            }
            return 1;
        }
        
        if(dp[i][j]!=-1)
            return dp[i][j];
            
        //boolean take=false,takeMultiple=false;
        int take=0,takeMultiple=0;
        if(pat.charAt(i-1)==str.charAt(j-1) || pat.charAt(i-1)=='?')
            take=search(i-1,j-1,pat,str,dp);
        else
        {
            if(pat.charAt(i-1)=='*')
                takeMultiple=search(i-1,j,pat,str,dp) | search(i,j-1,pat,str,dp);
        }
        
        dp[i][j]=(take==1|takeMultiple==1)?1:0;
        if(dp[i][j]==1)
            return 1;
            
        return dp[i][j]=0;
    }
}
