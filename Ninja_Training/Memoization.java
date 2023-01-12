import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][]=new int[n][4];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return ninjaPoints(n-1,3,points,dp);
    }
    static int ninjaPoints(int days,int last,int[][]points,int[][]dp)
    {
        if(days==0)
        {
            int max=0;
            for(int task=0;task<=2;task++)
            {
                if(task!=last)
                {
                    max=Math.max(max,points[0][task]);
                }
            }
            return dp[days][last]=max;
        }
        
        if(dp[days][last]!=-1)
            return dp[days][last];
        
        int max=0;
        for(int i=0;i<=2;i++)
        {
            if(i!=last)
            {
                int point=points[days][i] + ninjaPoints(days-1,i,points,dp);
                max=Math.max(point,max);
            }
        }
        return dp[days][last]=max;
    }
}
