public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

       int dp[]=new int[4];
        dp[0]=Math.max(points[0][1],points[0][2]);
        dp[1]=Math.max(points[0][0],points[0][2]);
        dp[2]=Math.max(points[0][0],points[0][1]);
       // dp[0][3]=0;
        for(int i=0;i<3;i++)
        {
            dp[3]=Math.max(points[0][i],dp[3]);
        }
        
        for(int day=1;day<n;day++)
        {
            int temp[]=new int[4];
            for(int last=0;last<=3;last++)
            {
                temp[last]=0;
                for(int task=0;task<3;task++)
                {
                    if(task!=last)
                    {
                    int activity=points[day][task]+dp[task]; //takes the new last i.e. activity of current day
                    temp[last]=Math.max(activity,temp[last]);
                    }
                }
            }
            dp=temp;
        }
        return dp[3];
    }

}
